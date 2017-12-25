package com.kunlun.api.service;

import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@FeignClient(value = "cloud-service-log")
public interface LogService {

    @PostMapping("")
    DataRet<String> addOrderLog(@RequestBody OrderLog orderLog);

    /**
     * 创建商品日志
     *
     * @param goodName
     * @param action
     * @param goodId
     * @return
     */
    @PostMapping("/log/add/goodLog")
    DataRet<String> addGoodLog(@RequestParam("goodName") String goodName,
                               @RequestParam("action") String action,
                               @RequestParam("goodId") Long goodId);
}
