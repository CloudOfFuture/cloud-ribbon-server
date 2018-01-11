package com.kunlun.api.controller;

import com.kunlun.api.service.PointService;
import com.kunlun.entity.Point;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.utils.WxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 积分检查
     *
     * @param pointValue
     * @param openid
     * @return
     */
    @PostMapping("/checkPoint")
    public DataRet<String> checkPoint(@RequestParam(value = "pointValue") Integer pointValue,
                                      @RequestParam(value = "openid") String openid) {
        return pointService.checkPoint(pointValue, openid);
    }


    /**
     * 根据userId查询用户积分
     *
     * @param userId
     * @return
     */
    @GetMapping("/findPointByUserId")
    public DataRet<Point> findPointByUserId(@RequestParam(value = "userId") String userId) {
        return pointService.findPointByUserId(userId);
    }

    /**
     * 根据wxCode查询用户积分
     *
     * @param wxCode
     * @return
     */
    @GetMapping("/findPointByWxCode")
    public DataRet<Point> findPointByWxCode(@RequestParam(value = "wxCode") String wxCode) {
        return pointService.findPointByUserId(WxUtil.getOpenId(wxCode));
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
                                   @RequestParam(value = "wxCode") String wxCode) {
        return pointService.findPointLog(pageNo, pageSize, wxCode);
    }

    /**
     * 操作用户积分（增,减）
     *
     * @param operatePoint
     * @param userId
     * @return
     */
    @PostMapping("/updatePoint")
    public DataRet<String> updatePoint(@RequestParam(value = "operatePoint") Integer operatePoint,
                                       @RequestParam(value = "userId") String userId) {
        return pointService.updatePoint(operatePoint, userId);
    }

}
