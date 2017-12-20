package com.kunlun.api.hystrix;

import com.kunlun.api.service.WxOrderService;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
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
    public PageResult findByCondition(OrderCondition orderCondition) {

        return new PageResult("ERROR", "订单列表故障");
    }
}
