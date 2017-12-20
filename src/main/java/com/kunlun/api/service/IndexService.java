package com.kunlun.api.service;

import com.kunlun.api.hystrix.IndexServiceHystrix;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
@FeignClient(value = "cloud-service-order",fallback = IndexServiceHystrix.class)
public interface IndexService {

    @GetMapping("/index")
    DataRet<String> index();

}
