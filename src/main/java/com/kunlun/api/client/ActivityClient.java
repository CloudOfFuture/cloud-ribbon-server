package com.kunlun.api.client;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.ActivityClientHystrix;
import com.kunlun.entity.Activity;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-29 15:44
 */
@FeignClient(value = "cloud-service-common", fallback = ActivityClientHystrix.class)
public interface ActivityClient {
    /**
     * 创建活动
     *
     * @param activity Activity
     * @return DataRet
     */
    @PostMapping("/activity/add")
    DataRet add(@RequestBody Activity activity);

    /**
     * 修改活动
     *
     * @param activity Activity
     * @return DataRet
     */
    @PostMapping("/activity/update")
    DataRet update(@RequestBody Activity activity);

    /**
     * 批量修改活动状态
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    @PostMapping("/activity/batchUpdateStatus")
    DataRet batchUpdateStatus(@RequestBody JSONObject jsonObject);

    /**
     * 根据活动id删除活动
     *
     * @param id Long
     * @return DataRet
     */
    @PostMapping("/activity/deleteById")
    DataRet deleteById(@RequestParam(value = "id") Long id);


    /**
     * 查询活动详情
     *
     * @param id 活动id、主键
     * @return DataRet
     */
    @GetMapping("/activity/findById")
    DataRet findById(@RequestParam(value = "id") Long id);

    /**
     * 条件模糊查询活动
     *
     * @param pageNo    Integer
     * @param pageSize  Integer
     * @param searchKey String
     * @param type      SECONDS_KILL 秒杀 SPELL_GROUP 拼团 PERFERRED 优选 FREE试用
     * @param status    0正常,1删除
     * @return PageResult
     */
    @GetMapping("/activity/findByCondition")
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "type", required = false) String type,
                               @RequestParam(value = "status", required = false) String status,
                               @RequestParam(value = "searchKey", required = false) String searchKey);

    /**
     * 活动跟商品绑定
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    @PostMapping("/activity/bindActivityWithGood")
    DataRet bindActivityWithGood(@RequestBody JSONObject jsonObject);

    /**
     * 活动跟商品解绑
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    @PostMapping("/activity/unbindActivityWithGood")
    DataRet unbindActivityWithGood(@RequestBody JSONObject jsonObject);
}
