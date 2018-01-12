package com.kunlun.api.service;

import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;

import java.util.List;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
public interface WxOrderService {


    /**
     * 退款
     *
     * @param orderId
     * @return
     */
    DataRet<String> applyRefund(Long orderId);


    /**
     * 我的订单列表/   分类查询（订单状态/支付类型）
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @param orderStatus
     * @param payType
     * @return
     */
    PageResult findByOpenid(Integer pageNo, Integer pageSize, String wxCode, String orderStatus, String payType);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    DataRet<Order> findById(Long orderId);

    /**
     * 取消订单
     *
     * @param orderId
     * @param ipAddress
     * @return
     */
    DataRet<String> cancelByOrder(Long orderId, String ipAddress);

    /**
     * 确认收货
     *
     * @param orderId
     * @param ipAddress
     * @return
     */
    DataRet<String> confirmByGood(Long orderId, String ipAddress);

    /**
     * 新增订单
     *
     * @param order
     * @return
     */
    DataRet<String> addOrder(Order order);

    /**
     * 修改订单预付款订单号
     *
     * @param id
     * @param prepayId
     * @return
     */
    DataRet<String> updateOrderPrepayId(Long id, String prepayId);

    /**
     * 查询退款中的订单列表
     *
     * @param orderStatus
     * @return
     */
    DataRet<List<Order>> findRefundingOrder(String orderStatus);

    /**
     * 查询未付款订单列表
     *
     * @param orderStatus
     * @return
     */
    DataRet<List<Order>> findUnPayOrder(String orderStatus);
}
