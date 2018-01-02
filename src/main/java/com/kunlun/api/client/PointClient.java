package com.kunlun.api.client;

import com.kunlun.api.hystrix.PointServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@FeignClient(value = "cloud-service-user-center", fallback = PointServiceHystrix.class)
public interface PointClient {
}
