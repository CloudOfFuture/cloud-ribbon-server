package com.kunlun.api.client;

import com.kunlun.api.hystrix.LogClientHystrix;
import com.kunlun.entity.GoodLog;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@FeignClient(value = "cloud-service-log", fallback = LogClientHystrix.class)
public interface LogClient {

    @PostMapping("")
    DataRet<String> addOrderLog(@RequestBody OrderLog orderLog);

    /**
     * 创建商品日志
     *
     * @param goodLog
     * @return
     */
    @PostMapping("/log/add/goodLog")
    DataRet<String> addGoodLog(@RequestBody GoodLog goodLog);
}
