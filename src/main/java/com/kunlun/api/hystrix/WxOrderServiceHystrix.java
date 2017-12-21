package com.kunlun.api.hystrix;

import com.kunlun.api.service.WxOrderService;
import com.kunlun.entity.OrderExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * 微信订单接口  断路器
 *
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@Component
public class WxOrderServiceHystrix implements WxOrderService {


    @Override
    public DataRet<String> refund(Long orderId, String wxCode) {
        return new DataRet<>("ERROR", "退款故障");
    }

    @Override
    public DataRet<OrderExt> findById(Long orderId) {
        return new DataRet<>("ERROR", "订单详情故障");
    }

    @Override
    public DataRet<String> confirmReceive(Long orderId) {
        return new DataRet<>("ERROR", "确认收货故障");
    }

    @Override
    public PageResult findByOpenid(Integer pageNo, Integer pageSize, String wxCode, String orderStatus, String payType) {
        return new PageResult("ERROR", "订单列表故障");
    }
}
