package com.kunlun.api.hystrix;

import com.kunlun.api.service.WxGoodService;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-22下午4:52
 * @desc
 */
@Component
public class WxGoodServiceHystrix implements WxGoodService {
    @Override
    public DataRet findById(Long goodId) {
        return new DataRet<>("not_found", "暂无数据");
    }

    @Override
    public PageResult findEstimateList(Integer pageNo, Integer pageSize, Long goodId) {
        return new PageResult<>();
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long categoryId, String searchKey) {
        return new PageResult<>();
    }

    @Override
    public DataRet findGoodSnapshot(Long orderId) {
        return new DataRet<>("not_found", "暂无数据");
    }
}
