package com.kunlun.api.hystrix;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.service.SellerGoodService;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-25上午9:54
 * @desc
 */
@Component
public class SellerGoodServiceHystrix implements SellerGoodService {
    @Override
    public DataRet<String> add(JSONObject object) {
        return new DataRet<>("add_error", "添加失败");
    }

    @Override
    public DataRet findById(Long id) {
        return new DataRet<>("not_found", "暂无数据");
    }

    @Override
    public DataRet updateGood(JSONObject object) {
        return new DataRet<>("update_error", "修改失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long userId, String type, String searchKey, String goodNo, String startDate, String endDate, Long brandId, String saleStatus, Long categoryId, String hot, String isNew, String freight) {
        return new PageResult();
    }

    @Override
    public DataRet deleteByIdList(JSONArray jsonArray) {
        return new DataRet<>("del_error", "删除失败");
    }

    @Override
    public DataRet updateGoodStock(Long id, Integer count) {
        return new DataRet<>("update_error", "修改失败");
    }

    @Override
    public DataRet batchUpdateSaleStatus(JSONObject object) {
        return new DataRet<>("update_error", "修改失败");
    }
}
