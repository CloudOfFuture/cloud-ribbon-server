package com.kunlun.api.service;

import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
public interface OrderService {


    /**
     * 测试
     *
     * @param orderId
     * @return
     */
    DataRet<String> test(Long orderId);

    /**
     * 订单列表
     *
     * @param orderNo   订单编号
     * @param phone     收货人手机号
     * @param status    订单状态
     * @param orderType 订单类型
     * @param searchKey 搜索关键字
     * @param pageNo    当前页
     * @param pageSize  每页条数
     * @return
     */
    PageResult list(String orderNo,
                    String phone,
                    String status,
                    String orderType,
                    String searchKey,
                    Integer pageNo,
                    Integer pageSize);

    /**
     * 发货
     *
     * @param orderCondition
     * @return
     */
    DataRet<String> sendGood(OrderCondition orderCondition);


    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    DataRet<String> modify(Order order);


    /**
     * 查询订单详情
     *
     * @param orderId
     * @param sellerId
     * @return
     */
    DataRet<Order> findById(Long orderId, Long sellerId);

    /**
     * 退款
     *
     * @param orderId
     * @param flag
     * @param remark
     * @param refundFee
     * @return
     */
    DataRet<String> auditRefund(Long orderId, String flag, String remark, Integer refundFee);

}
