package com.kunlun.api.client;

import com.kunlun.api.hystrix.EstimateClientHystrix;
import com.kunlun.entity.Estimate;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-03.
 */
@FeignClient(value = "cloud-service-common", fallback = EstimateClientHystrix.class)
public interface EstimateClient {

    /**
     * 评价
     *
     * @param estimate
     * @return
     */
    @PostMapping(value = "/estimate/estimate")
    DataRet estimate(@RequestBody Estimate estimate);
}
