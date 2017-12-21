package com.kunlun.api.hystrix;

import com.kunlun.api.service.IndexService;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import feign.Contract;
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

    /**
     * 测试POST请求
     *
     * @param order
     * @return
     */
    @Override
    public DataRet<String> testPost(Order order) {
        return new DataRet<>("ERROR", "测试POST请求失败");
    }
}
