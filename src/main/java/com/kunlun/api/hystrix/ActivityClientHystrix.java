package com.kunlun.api.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.ActivityClient;
import com.kunlun.entity.Activity;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-29 15:44
 */
@Component
public class ActivityClientHystrix implements ActivityClient {
    @Override
    public DataRet add(Activity activity) {
        return new DataRet("ERROR", "新增失败");
    }

    @Override
    public DataRet update(Activity activity) {
        return new DataRet("ERROR", "修改失败");
    }

    @Override
    public DataRet batchUpdateStatus(JSONObject jsonObject) {
        return new DataRet("ERROR", "修改失败");
    }

    @Override
    public DataRet deleteById(Long id) {
        return new DataRet("ERROR", "删除失败");
    }

    @Override
    public DataRet findById(Long id) {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String type, String status, String searchKey) {
        return new PageResult();
    }

    @Override
    public DataRet bindActivityWithGood(JSONObject jsonObject) {
        return new DataRet("ERROR", "绑定失败");
    }

    @Override
    public DataRet unbindActivityWithGood(JSONObject jsonObject) {
        return new DataRet("ERROR", "解绑失败");
    }
}
