package com.kunlun.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.service.ActivityService;
import com.kunlun.entity.Activity;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-29 03:01
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 创建活动
     *
     * @param activity Activity
     * @return DataRet
     */
    @PostMapping("/add")
    public DataRet add(@RequestBody Activity activity) {
        return activityService.add(activity);
    }


    /**
     * 修改活动
     *
     * @param activity Activity
     * @return DataRet
     */
    @PostMapping("/update")
    public DataRet update(@RequestBody Activity activity) {
        return activityService.update(activity);
    }

    /**
     * 批量修改活动状态
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    @PostMapping("/batchUpdateStatus")
    public DataRet batchUpdateStatus(@RequestBody JSONObject jsonObject) {
        return activityService.batchUpdateStatus(jsonObject);
    }


    /**
     * 根据活动id删除活动
     *
     * @param id Long
     * @return DataRet
     */
    @PostMapping("/deleteById")
    public DataRet deleteById(@RequestParam(value = "id") Long id) {
        return activityService.deleteById(id);
    }


    /**
     * 查询活动详情
     *
     * @param id 活动id、主键
     * @return DataRet
     */
    @GetMapping("/findById")
    public DataRet findById(@RequestParam(value = "id") Long id) {
        return activityService.findById(id);
    }

    /**
     * 条件模糊查询活动
     *
     * @param pageNo    Integer
     * @param pageSize  Integer
     * @param searchKey String
     * @param type      SECONDS_KILL 秒杀 SPELL_GROUP 拼团 PERFERRED 优选 FREE 试用
     * @param status    NORMAL 正常 UN_NORMAL 非正常 EXPIRE 已过期
     * @return PageResult
     */
    @GetMapping("/findByCondition")
    public PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                                      @RequestParam(value = "pageSize") Integer pageSize,
                                      @RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "status", required = false) String status,
                                      @RequestParam(value = "searchKey", required = false) String searchKey) {
        return activityService.findByCondition(pageNo, pageSize, type, status, searchKey);
    }


    /**
     * 活动跟商品绑定
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    @PostMapping("/bindActivityWithGood")
    public DataRet bindActivityWithGood(@RequestBody JSONObject jsonObject) {
        return activityService.bindActivityWithGood(jsonObject);
    }

    /**
     * 活动跟商品解绑
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    @PostMapping("/unbindActivityWithGood")
    public DataRet unbindActivityWithGood(@RequestBody JSONObject jsonObject) {
        return activityService.unbindActivityWithGood(jsonObject);
    }

    /**
     * 活动列表
     *
     * @param pageNo
     * @param pageSize
     * @param activityType
     * @return
     */
    @GetMapping("/findActivityList")
    public PageResult findByActivityType(@RequestParam(value = "pageNo") Integer pageNo,
                                         @RequestParam(value = "pageSize") Integer pageSize,
                                         @RequestParam(value = "activityType") String activityType){
        return activityService.findByActivityType(pageNo,pageSize,activityType);
    }
}
