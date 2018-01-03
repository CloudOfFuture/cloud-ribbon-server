package com.kunlun.api.controller;

import com.kunlun.api.service.PointService;
import com.kunlun.entity.Point;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@RestController
@RequestMapping("point")
public class PointController {

    @Autowired
    private PointService pointService;

    @GetMapping("/checkPoint")
    public String checkPoint(@RequestParam(value = "pointValue") Integer pointValue,
                             @RequestParam(value = "openid") String openid) {
        return pointService.checkPoint(pointValue,openid);
    }


    /**
     * 根据userId查询用户积分
     * @param userId
     * @return
     */
    @GetMapping("/findPointByUserId")
    public DataRet<Point> findPointByUserId(String userId){
        return pointService.findPointByUserId(userId);
    }


    /**
     * 获取积分记录列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    @GetMapping("/findPointLog")
    public PageResult findPointLog(@RequestParam(value = "pageNo") Integer pageNo,
                                   @RequestParam(value = "pageSize") Integer pageSize,
                                   @RequestParam(value = "wxCode") String wxCode){
        return pointService.findPointLog(pageNo,pageSize,wxCode);
    }
}
