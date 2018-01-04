package com.kunlun.api.service;

import com.kunlun.api.hystrix.PointServiceHystrix;
import com.kunlun.entity.Point;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@FeignClient(value = "cloud-service-user-center", fallback = PointServiceHystrix.class)
public interface PointService {


    /**
     * 积分校验
     *
     * @param pointValue
     * @param wxCode
     * @return
     */
    DataRet<String> checkPoint(Integer pointValue, String wxCode);

    /**
     * 获取积分详情
     *
     * @param wxCode
     * @return
     */
    DataRet<Point> findPointByUserId(String wxCode);

    /**
     *
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    PageResult findPointLog(Integer pageNo, Integer pageSize, String wxCode);


    /**
     * 操作用户积分
     *
     * @param point
     * @param wxCode
     * @return
     */
    DataRet<String> updatePoint(Integer point, String wxCode);
}
