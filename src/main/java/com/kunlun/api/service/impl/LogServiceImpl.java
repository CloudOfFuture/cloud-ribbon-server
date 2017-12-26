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

    /**
     * 创建订单日志
     *
     * @param orderLog
     * @return
     */
    @Override
    public DataRet<String> addOrderLog(OrderLog orderLog) {
        return logClient.addOrderLog(orderLog);
    }

    /**
     * 创建商品日志
     *
     * @param goodLog
     * @return
     */
    @Override
    public DataRet<String> addGoodLog(GoodLog goodLog) {
        return logClient.addGoodLog(goodLog);
    }

    /**
     * 创建订单物流信息
     *
     * @param logistics
     * @return
     */
    @Override
    public DataRet<String> addLogisticLog(Logistics logistics) {
        return logClient.addLogisticLog(logistics);
    }
}
