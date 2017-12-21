package com.kunlun.api.hystrix;

import com.kunlun.api.service.LogService;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@Component
public class LogServiceHystrix implements LogService {
    @Override
    public DataRet<String> addOrderLog(OrderLog orderLog) {
        return new DataRet<>("ERROR", "订单日志接口异常");
    }
}
