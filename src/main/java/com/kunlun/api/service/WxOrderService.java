package com.kunlun.api.service;

import com.kunlun.api.hystrix.WxOrderServiceHystrix;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@FeignClient(value = "cloud-service-order", fallback = WxOrderServiceHystrix.class)
public interface WxOrderService {

    @GetMapping("")
    public PageResult findByCondition(@RequestBody OrderCondition orderCondition);
}
