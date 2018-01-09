package com.kunlun.api.client;

import com.kunlun.api.hystrix.FreeClientHystrix;
import com.kunlun.result.DataRet;
import com.kunlun.utils.IpUtil;
import com.kunlun.wxentity.UnifiedRequestData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-09.
 */
@FeignClient(value = "cloud-service-pay",fallback = FreeClientHystrix.class)
public interface FreeClient {

    /**
     * 试用预付款订单
     *
     * @param unifiedRequestData
     * @return
     */
    @PostMapping("/wx/free/apply")
     DataRet apply(@RequestBody UnifiedRequestData unifiedRequestData);
}
