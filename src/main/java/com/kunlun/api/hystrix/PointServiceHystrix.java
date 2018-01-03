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
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<String> checkPoint(Integer pointValue, String wxCode) {
        return new DataRet<>("ERROR","校验失败");
    }

    /**
     *获取详情
     *
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<Point> findPointByUserId(String wxCode) {
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


    /**
     * 操作积分
     *
     * @param point
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<String> updatePoint(Integer point, String wxCode) {
        return new DataRet<>("ERROR","操作积分失败");
    }
}
