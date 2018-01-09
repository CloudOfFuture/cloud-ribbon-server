package com.kunlun.api.hystrix;

import com.kunlun.api.client.FreeClient;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-09.
 */
@Component
public class FreeClientHystrix implements FreeClient{


    /**
     * 生成预付款订单
     *
     * @param unifiedRequestData
     * @param request
     * @return
     */
    @Override
    public DataRet apply(UnifiedRequestData unifiedRequestData, HttpServletRequest request) {
        return new DataRet("ERROR","生成预付款订单失败");
    }
}
