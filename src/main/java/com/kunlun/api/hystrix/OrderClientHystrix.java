package com.kunlun.api.hystrix;

import com.kunlun.api.client.OrderClient;
import com.kunlun.api.service.OrderService;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@Component
public class OrderClientHystrix implements OrderClient {

    /**
     * 测试
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<String> test(Long orderId) {
        return new DataRet<>("ERROR", "测试接口异常");
    }


    /**
     * @param orderNo   订单编号
     * @param phone     收货人手机号
     * @param status    订单状态
     * @param orderType 订单类型
     * @param searchKey 搜索关键字
     * @param pageNo    当前页
     * @param pageSize  每页条数
     * @return
     */
    @Override
    public PageResult list(String orderNo, String phone, String status, String orderType, String searchKey, Integer pageNo, Integer pageSize) {
        return new PageResult("ERROR", "订单列表接口异常");
    }

    /**
     * 发货
     *
     * @param orderCondition
     * @return
     */
    @Override
    public DataRet<String> sendGood(OrderCondition orderCondition) {
        return new DataRet<>("ERROR", "发货接口异常");
    }

    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    @Override
    public DataRet<String> modify(Order order) {
        return new DataRet<>("ERROR", "订单修改接口异常");
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
        return new DataRet<>("ERROR", "订单详情接口异常");
    }

    @Override
    public DataRet<Order> findByIdForOrder(Long orderId, Long sellerId) {
        return new DataRet<>("ERROR", "请求失败");
    }

    @Override
    public DataRet<String> auditRefund(Long orderId, String flag, String remark, Integer refundFee) {
        return new DataRet<>("ERROR", "请求失败");
    }
}
