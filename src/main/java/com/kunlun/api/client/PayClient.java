package com.kunlun.api.client;

import com.kunlun.api.hystrix.PayClientHystrix;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-12.
 */
@FeignClient(value = "cloud-service-pay",fallback = PayClientHystrix.class)
public interface PayClient {

    /**
     * 统一下单
     *
     * @param unifiedRequestData
     * @return
     */
    @PostMapping("/pay/order/unifiedOrder")
     DataRet<Object> unifiedOrder(@RequestBody UnifiedRequestData unifiedRequestData);
}
