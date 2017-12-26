package com.kunlun.api.service.impl;

import com.kunlun.api.client.LogClient;
import com.kunlun.api.client.OrderClient;
import com.kunlun.api.service.OrderService;
import com.kunlun.entity.Logistics;
import com.kunlun.entity.Order;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
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
        DataRet<String> orderLogRet = logClient.addOrderLog(orderLog(orderCondition.getOrderId(), orderNo, "发货"));
        if (!orderLogRet.isSuccess()) {
            return orderLogRet;
        }
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
        return null;
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
        return null;
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
}
