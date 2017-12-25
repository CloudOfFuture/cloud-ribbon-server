package com.kunlun.api.client;

import com.kunlun.api.hystrix.IndexClientHystrix;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */
@FeignClient(value = "cloud-service-order", fallback = IndexClientHystrix.class)
public interface IndexClient {

    @GetMapping("/index/log")
    DataRet<String> index(@RequestParam("orderNo") String orderNo);
}
