package com.kunlun.api.service.impl;

import com.kunlun.api.client.PayClient;
import com.kunlun.api.service.PayService;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-12.
 */
@Service
public class PayServiceImpl implements PayService{


    @Autowired
    private PayClient payClient;

    /**
     * 统一下单
     *
     * @param unifiedRequestData
     * @return
     */
    @Override
    public DataRet<Object> unifiedOrder(UnifiedRequestData unifiedRequestData) {
        return payClient.unifiedOrder(unifiedRequestData);
    }
}
