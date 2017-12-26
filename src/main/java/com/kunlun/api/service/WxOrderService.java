package com.kunlun.api.service;

import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;

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
    DataRet<String> refund(Long orderId);


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
}
