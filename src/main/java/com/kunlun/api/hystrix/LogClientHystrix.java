package com.kunlun.api.hystrix;

import com.kunlun.api.client.LogClient;
import com.kunlun.api.service.LogService;
import com.kunlun.entity.GoodLog;
import com.kunlun.entity.Logistics;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@Component
public class LogClientHystrix implements LogClient {
    @Override
    public DataRet<String> addOrderLog(OrderLog orderLog) {
        return new DataRet<>("ERROR", "订单日志接口异常");
    }


    /**
     * 创建商品日志失败回滚
     *
     * @param goodLog
     * @return
     */
    @Override
    public DataRet<String> addGoodLog(GoodLog goodLog) {
        return new DataRet<>("ERROR", "商品日志接口异常");
    }

    /**
     * 创建发货日志
     *
     * @param logistics
     * @return
     */
    @Override
    public DataRet<String> addLogisticLog(Logistics logistics) {
        return new DataRet<>("ERROR", "发货日志接口异常");
    }


}
