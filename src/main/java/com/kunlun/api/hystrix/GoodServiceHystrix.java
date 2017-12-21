package com.kunlun.api.hystrix;

import com.kunlun.api.service.GoodService;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-21.
 */
@Component
public class GoodServiceHystrix implements GoodService {

    @Override
    public DataRet<String> add(Good good) {
        return new DataRet<>("ERROR","创建失败");
    }
}
