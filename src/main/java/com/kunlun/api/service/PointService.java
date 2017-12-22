package com.kunlun.api.service;

import com.kunlun.api.hystrix.PointServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@FeignClient(value = "cloud-service-user-center", fallback = PointServiceHystrix.class)
public interface PointService {

    /**
     * 积分检查
     *
     * @param pointValue
     * @param openid
     * @return
     */
    @GetMapping("/point/checkPoint")
    String checkPoint(@RequestParam(value = "pointValue") Integer pointValue,
                      @RequestParam(value = "openid") String openid);
}
