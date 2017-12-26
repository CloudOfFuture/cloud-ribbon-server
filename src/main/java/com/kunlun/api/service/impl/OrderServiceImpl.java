package com.kunlun.api.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.kunlun.api.client.OrderClient;
import com.kunlun.api.service.OrderService;
import com.kunlun.entity.Order;
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
    public PageResult list(String orderNo, String phone, String status, String type, String searchKey, Integer pageNo, Integer pageSize) {
        return orderClient.list(orderNo, phone, status, type, searchKey, pageNo, pageSize);
    }

    /**
     * 发货
     *
     * @param orderCondition
     * @return
     */
    @TxTransaction
    @Transactional
    @Override
    public DataRet<String> sendGood(OrderCondition orderCondition) {
        DataRet<String> ret = orderClient.sendGood(orderCondition);
        if(ret.isSuccess()){
            //生成发货日志

        }
        return ret;
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
}
