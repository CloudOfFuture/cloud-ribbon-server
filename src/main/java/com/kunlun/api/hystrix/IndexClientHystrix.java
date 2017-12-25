package com.kunlun.api.hystrix;

import com.kunlun.api.client.IndexClient;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */
@Component
public class IndexClientHystrix implements IndexClient {
    @Override
    public void index(String orderNo) {
        System.out.println("index接口异常");
    }
}
