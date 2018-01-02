package com.kunlun.api.hystrix;

import com.kunlun.api.client.IndexClient;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */
@Component
public class IndexClientHystrix implements IndexClient {
    @Override
    public DataRet<String> index(String orderNo) {
        return new DataRet<>("Index接口异常");
    }
}
