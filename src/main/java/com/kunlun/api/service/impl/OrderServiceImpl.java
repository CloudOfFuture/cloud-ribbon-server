package com.kunlun.api.service.impl;

import com.kunlun.api.client.LogClient;
import com.kunlun.api.client.OrderClient;
import com.kunlun.api.service.OrderService;
import com.kunlun.entity.Logistics;
import com.kunlun.entity.Order;
import com.kunlun.entity.OrderLog;
import com.kunlun.enums.CommonEnum;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.utils.CommonUtil;
import com.kunlun.wxentity.OrderCondition;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private LogClient logClient;

    /**
     * 测试
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<String> test(Long orderId) {
        return orderClient.test(orderId);
    }

    /**
     * 分页查询列表
     *
     * @param orderNo   订单编号
     * @param phone     收货人手机号
     * @param status    订单状态
     * @param type      订单类型
     * @param searchKey 搜索关键字
     * @param pageNo    当前页
     * @param pageSize  每页条数
     * @return
     */
    @Override
    public PageResult list(String orderNo, String phone, String status, String type,
                           String searchKey, Integer pageNo, Integer pageSize) {
        return orderClient.list(orderNo, phone, status, type, searchKey, pageNo, pageSize);
    }

    /**
     * 发货
     *
     * @param orderCondition
     * @return
     */
    @Transactional
    @Override
    public DataRet<String> sendGood(OrderCondition orderCondition) {
        Long orderId = orderCondition.getOrderId();
        if (null == orderId) {
            return new DataRet<>("ERROR", "参数错误");
        }
        if (StringUtils.isNullOrEmpty(orderCondition.getLogisticNo())) {
            return new DataRet<>("ERROR", "运单号不能为空");
        }
        if (StringUtils.isNullOrEmpty(orderCondition.getLogisticName())) {
            return new DataRet<>("ERROR", "快递公司不能为空");
        }
        DataRet<String> ret = orderClient.sendGood(orderCondition);
        if (!ret.isSuccess()) {
            return ret;
        }
        String orderNo = ret.getBody();
        //生成发货日志
        Logistics logistics = this.logistics(orderCondition.getOrderId(), orderCondition.getLogisticNo(),
                orderCondition.getLogisticName(), orderCondition.getSellerId());
        DataRet<String> logisticRet = logClient.addLogisticLog(logistics);
        if (!logisticRet.isSuccess()) {
            return logisticRet;
        }
        logClient.addOrderLog(orderLog(orderCondition.getOrderId(), orderNo, "发货"));
        return new DataRet<>("发货成功");
    }

    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    @Override
    public DataRet<String> modify(Order order) {
        DataRet<String> orderRet = orderClient.modify(order);
        if (!orderRet.isSuccess()) {
            return orderRet;
        }
        logClient.addOrderLog(orderLog(order.getId(), order.getOrderNo(), "修改订单"));
        return new DataRet<>("订单修改成功");
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @param sellerId
     * @return
     */
    @Override
    public DataRet<Order> findById(Long orderId, Long sellerId) {
        return orderClient.findById(orderId, sellerId);
    }

    /**
     * 退款审核
     *
     * @param orderId
     * @param flag      AGREE 同意  REFUSE  拒绝
     * @param remark
     * @param refundFee
     * @return
     */
    @Override
    public DataRet<String> auditRefund(Long orderId, String flag, String remark, Integer refundFee) {
        //创建待退款日志
        logClient.addOrderLog(CommonUtil.constructOrderLog(null, "等待退款", "", orderId));
        return orderClient.auditRefund(orderId, flag, remark, refundFee);
    }


    /**
     * 组装 发货信息
     *
     * @param orderId
     * @param logisticNo
     * @param logisticName
     * @param senderId
     * @return
     */
    private Logistics logistics(Long orderId, String logisticNo, String logisticName, Long senderId) {
        Logistics logistics = new Logistics();
        logistics.setSenderId(senderId);
        logistics.setOrderId(orderId);
        logistics.setLogisticName(logisticName);
        logistics.setLogisticNo(logisticNo);
        return logistics;
    }

    /**
     * 组装订单日志
     *
     * @param orderId
     * @param orderNo
     * @param action
     * @return
     */
    private OrderLog orderLog(Long orderId, String orderNo, String action) {
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(orderId);
        orderLog.setOrderNo(orderNo);
        orderLog.setAction(action);
        return orderLog;
    }

    /**
     * 组装退款订单对象
     *
     * @param orderId
     * @param status
     * @param refundFee
     * @param remark
     * @return
     */
    private Order constructOrder(Long orderId, String status, Integer refundFee, String remark) {
        Order order = new Order();
        order.setId(orderId);
        order.setOrderStatus(status);
        order.setRefundFee(refundFee);
        order.setRemark(remark);
        return order;
    }
}
