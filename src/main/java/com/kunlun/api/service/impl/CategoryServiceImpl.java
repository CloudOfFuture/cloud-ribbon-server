package com.kunlun.api.service.impl;

import com.kunlun.api.client.CategoryClient;
import com.kunlun.api.service.CategoryService;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-27.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryClient categoryClient;

    /**
     * 商品绑定类目
     *
     * @param categoryId
     * @param goodId
     * @return
     */
    @Override
    public DataRet<String> bind(Long categoryId, Long goodId) {
        return categoryClient.bind(categoryId,goodId);
    }


    /**
     * 商品解绑类目
     *
     * @param goodId
     * @return
     */
    @Override
    public DataRet<String> unbinding(Long goodId) {
        return categoryClient.unbinding(goodId);
    }
}
