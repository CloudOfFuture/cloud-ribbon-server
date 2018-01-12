package com.kunlun.api.client;

import com.kunlun.api.hystrix.GroupClientHystrix;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-12.
 */
@FeignClient(value = "cloud-service-pay", fallback = GroupClientHystrix.class)
public interface GroupClient {

    /**
     * 参见拼团
     *
     * @param unifiedRequestData
     * @return
     */
    @PostMapping(value = "joinGroup")
    DataRet joinGroup(@RequestBody UnifiedRequestData unifiedRequestData);
}
