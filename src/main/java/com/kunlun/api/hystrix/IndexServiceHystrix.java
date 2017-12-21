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
    @Override
    public DataRet<String> index() {
        return new DataRet<>("ERROR", "负载均衡故障");
    }
}
