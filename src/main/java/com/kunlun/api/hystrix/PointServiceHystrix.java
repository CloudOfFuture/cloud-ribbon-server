package com.kunlun.api.hystrix;

import com.kunlun.api.client.PointClient;
import com.kunlun.api.service.PointService;
import com.kunlun.entity.Point;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@Component
public class PointServiceHystrix implements PointClient {

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

    /**
     *
     *
     * @param userId
     * @return
     */
    @Override
    public DataRet<Point> findPointByUserId(String userId) {
        return new DataRet<>("ERROR","查无结果");
    }


    /**
     * 获取积分记录
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    @Override
    public PageResult findPointLog(Integer pageNo, Integer pageSize, String wxCode) {
        return new PageResult("ERROR","获取积分记录失败");
    }
}
