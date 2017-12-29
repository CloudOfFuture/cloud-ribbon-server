package com.kunlun.api.service;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.entity.Activity;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;


/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-29 15:43
 */
public interface ActivityService {
    /**
     * 创建活动
     *
     * @param activity Activity
     * @return DataRet
     */
    DataRet add(Activity activity);

    /**
     * 修改活动
     *
     * @param activity Activity
     * @return DataRet
     */
    DataRet update(Activity activity);

    /**
     * 删除活动
     *
     * @param id Long
     * @return DataRet
     */
    DataRet deleteById(Long id);

    /**
     * 查询活动
     *
     * @param pageNo    Integer
     * @param pageSize  Integer
     * @param type      SECONDS_KILL 秒杀 SPELL_GROUP 拼团 PERFERRED 优选 FREE试用
     * @param status    NORMAL正常 UN_NORMAL 非正常 EXPIRE已过期
     * @param searchKey String
     * @return Page
     */
    PageResult findByCondition(Integer pageNo, Integer pageSize, String type, String status, String searchKey);

    /**
     * 根据活动id查询活动详情
     *
     * @param id Long
     * @return DataRet
     */
    DataRet findById(Long id);

    /**
     * 绑定活动跟商品
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    DataRet bindActivityWithGood(JSONObject jsonObject);

    /**
     * 批量修改活动状态
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    DataRet batchUpdateStatus(JSONObject jsonObject);

    /**
     * 解绑商品跟图片
     *
     * @param jsonObject JSONObject
     * @return DataRet
     */
    DataRet unbindActivityWithGood(JSONObject jsonObject);
}
