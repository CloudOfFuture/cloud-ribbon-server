package com.kunlun.api.service;

import com.kunlun.api.hystrix.GoodServiceHystrix;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-21.
 */
@FeignClient(value = "cloud-service-good",fallback = GoodServiceHystrix.class)
public interface GoodService {


    @PostMapping("/backstage/good/add")
    DataRet<String> add(@RequestBody Good good);
}
