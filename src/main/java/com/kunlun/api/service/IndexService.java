package com.kunlun.api.service;

import com.kunlun.api.hystrix.IndexServiceHystrix;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
@FeignClient(value = "cloud-service-order", fallback = IndexServiceHystrix.class)
public interface IndexService {

    /**
     * 测试服务之间接口调用
     *
     * @param orderId
     * @return
     */
    @GetMapping("/index/log")
    DataRet<String> logTest(@RequestParam(value = "order_id") Long orderId);

    /**
     * 测试POST请求
     * @param order
     * @return
     */
    @PostMapping("/index/test/post")
    DataRet<String> testPost(@RequestBody Order order);
}
