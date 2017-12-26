package com.kunlun.api.service.impl;

import com.kunlun.api.client.LogClient;
import com.kunlun.api.service.LogService;
import com.kunlun.entity.GoodLog;
import com.kunlun.entity.Logistics;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26下午2:18
 * @desc
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogClient logClient;

    @Override
    public DataRet<String> addOrderLog(OrderLog orderLog) {
        return logClient.addOrderLog(orderLog);
    }

    @Override
    public DataRet<String> addGoodLog(GoodLog goodLog) {
        return logClient.addGoodLog(goodLog);
    }

    @Override
    public DataRet<String> addLogisticLog(Logistics logistics) {
        return logClient.addLogisticLog(logistics);
    }
}
