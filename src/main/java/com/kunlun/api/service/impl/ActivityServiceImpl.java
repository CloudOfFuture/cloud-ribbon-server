package com.kunlun.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.ActivityClient;
import com.kunlun.api.service.ActivityService;
import com.kunlun.entity.Activity;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-29 15:43
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityClient activityClient;

    @Override
    public DataRet add(Activity activity) {
        return activityClient.add(activity);
    }

    @Override
    public DataRet update(Activity activity) {
        if (activity.getId() == null) {
            return new DataRet("ERROR", "id不能为空");
        }
        return activityClient.update(activity);
    }

    @Override
    public DataRet deleteById(Long id) {
        if (id == null) {
            return new DataRet("ERROR", "id不能为空");
        }
        return activityClient.deleteById(id);
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String type, String status, String searchKey) {
        if (pageNo == null || pageSize == null) {
            return new PageResult();
        }
        return activityClient.findByCondition(pageNo, pageSize, type, status, searchKey);
    }

    @Override
    public DataRet findById(Long id) {
        if (id == null) {
            return new DataRet("ERROR", "id不能为空");
        }
        return activityClient.findById(id);
    }

    @Override
    public DataRet bindActivityWithGood(JSONObject jsonObject) {
        return activityClient.bindActivityWithGood(jsonObject);
    }

    @Override
    public DataRet batchUpdateStatus(JSONObject jsonObject) {
        return activityClient.batchUpdateStatus(jsonObject);
    }

    @Override
    public DataRet unbindActivityWithGood(JSONObject jsonObject) {
        return activityClient.unbindActivityWithGood(jsonObject);
    }
}
