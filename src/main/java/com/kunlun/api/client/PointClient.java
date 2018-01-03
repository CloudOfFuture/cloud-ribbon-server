package com.kunlun.api.client;

import com.kunlun.api.hystrix.PointServiceHystrix;
import com.kunlun.entity.Point;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@FeignClient(value = "cloud-service-user-center", fallback = PointServiceHystrix.class)
public interface PointClient {




    /**
     * 积分检查
     *
     * @param pointValue
     * @param wxCode
     * @return
     */
    @GetMapping("/point/checkPoint")
     DataRet<String> checkPoint(@RequestParam(value = "pointValue") Integer pointValue,
                                      @RequestParam(value = "wxCode") String wxCode);

    /**
     * 根据userId查询用户积分
     * @param wxCode
     * @return
     */
    @GetMapping("/point/findPointByUserId")
     DataRet<Point> findPointByUserId(@RequestParam(value = "wxCode") String wxCode);


    /**
     * 获取积分记录列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    @GetMapping("/findPointLog")
     PageResult findPointLog(@RequestParam(value = "pageNo") Integer pageNo,
                                   @RequestParam(value = "pageSize") Integer pageSize,
                                   @RequestParam(value = "wxCode") String wxCode);


    /**
     * 操作用户积分（增,减）
     * @param point
     * @param wxCode
     * @return
     */
    @PostMapping("/updatePoint")
     DataRet<String> updatePoint(@RequestParam(value = "point") Integer point,
                                       @RequestParam(value = "wxCode") String wxCode);
}
