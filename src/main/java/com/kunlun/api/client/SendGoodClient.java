package com.kunlun.api.client;

import com.kunlun.api.hystrix.SendGoodClientHystrix;
import com.kunlun.entity.SendGood;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-09.
 */
@FeignClient(value = "cloud-service-common", fallback = SendGoodClientHystrix.class)
public interface SendGoodClient {

    /**
     * 新增发货信息
     *
     * @param sendGood
     * @return
     */
    @PostMapping(value = "/sendGood/add")
    DataRet add(@RequestBody SendGood sendGood);

    @GetMapping(value = "/sendGood/findById")
    DataRet findById(@RequestParam(value = "id") Long id);
}
