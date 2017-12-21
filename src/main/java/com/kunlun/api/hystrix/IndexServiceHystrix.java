package com.kunlun.api.hystrix;

import com.kunlun.api.service.IndexService;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
@Component
public class IndexServiceHystrix implements IndexService {

    /**
     * 测试服务之间接口调用
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<String> logTest(Long orderId) {
        return new DataRet<>("ERROR", "日志接口调用异常");
    }
}
