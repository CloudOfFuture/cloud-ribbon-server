package com.kunlun.api.service;

import com.kunlun.api.hystrix.GoodLogServiceHystrix;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
@FeignClient(value = "cloud-service-log",fallback = GoodLogServiceHystrix.class)
public interface GoodLogService {


    /**
     * 新增商品日志
     *
     * @param goodName
     * @param action
     * @param id
     * @return
     */
    @GetMapping("/backstage/goodLog/saveGoodLog")
    DataRet<String> saveGoodLog(@RequestParam("good_name") String goodName,
                                @RequestParam("action") String action,
                                @RequestParam("id") Long id);
}
