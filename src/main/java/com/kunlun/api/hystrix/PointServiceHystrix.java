package com.kunlun.api.hystrix;

import com.kunlun.api.service.PointService;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@Component
public class PointServiceHystrix implements PointService {

    /**
     * 积分校验
     * @param pointValue
     * @param openid
     * @return
     */
    @Override
    public String checkPoint(Integer pointValue, String openid) {
        return "积分无效";
    }
}
