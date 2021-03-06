package com.kunlun.api.service;

import com.kunlun.entity.GoodLog;
import com.kunlun.entity.Logistics;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */

public interface LogService {

    DataRet<String> addOrderLog(OrderLog orderLog);

    /**
     * 创建商品日志
     *
     * @param goodLog
     * @return
     */
    DataRet<String> addGoodLog(GoodLog goodLog);


    /**
     * 创建 日志
     *
     * @param logistics
     * @return
     */
    DataRet<String> addLogisticLog(Logistics logistics);
}
