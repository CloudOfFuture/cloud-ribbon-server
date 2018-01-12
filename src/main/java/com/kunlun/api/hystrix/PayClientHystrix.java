package com.kunlun.api.hystrix;

import com.kunlun.api.client.PayClient;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-12.
 */
@Component
public class PayClientHystrix implements PayClient{


    /**
     * 统一下单
     *
     * @param unifiedRequestData
     * @return
     */
    @Override
    public DataRet<Object> unifiedOrder(UnifiedRequestData unifiedRequestData) {
        return new DataRet<>("ERROR","普通支付预付款订单接口出错");
    }
}
