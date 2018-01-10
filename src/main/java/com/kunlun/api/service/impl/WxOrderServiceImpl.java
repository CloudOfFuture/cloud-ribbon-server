package com.kunlun.api.service.impl;

import com.kunlun.api.client.WxOrderClient;
import com.kunlun.api.service.WxOrderService;
import com.kunlun.entity.Order;
import com.kunlun.entity.OrderExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@Service
public class WxOrderServiceImpl implements WxOrderService {

    @Autowired
    private WxOrderClient wxOrderClient;


    /**
     * 退款
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<String> applyRefund(Long orderId) {
        return wxOrderClient.applyRefund(orderId);
    }

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
    @Override
    public PageResult findByOpenid(Integer pageNo, Integer pageSize, String wxCode, String orderStatus, String payType) {
        return wxOrderClient.findByOpenid(pageNo, pageSize, wxCode, orderStatus, payType);
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<Order> findById(Long orderId) {
        return wxOrderClient.findById(orderId);
    }
    /**
     * 取消订单
     *
     * @param orderId 订单id
     * @param ipAddress 请求ip
     * @return
     */
    @Override
    public DataRet<String> cancelByOrder(Long orderId, String ipAddress) {
        return wxOrderClient.cancelByOrder(orderId, ipAddress);
    }
    /**
     * 确认收货
     *
     * @param orderId 订单id
     * @param ipAddress 请求ip
     * @return
     */
    @Override
    public DataRet<String> confirmByGood(Long orderId, String ipAddress) {
        return wxOrderClient.confirmByGood(orderId, ipAddress);
    }
}
