package com.kunlun.api.service;


import com.kunlun.api.hystrix.DeliveryServiceHystrix;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
public interface DeliveryService {

    /**
     * 根据id查找收获地址详情
     * @param id
     * @return
     */
    DataRet findById(Long id);

}
