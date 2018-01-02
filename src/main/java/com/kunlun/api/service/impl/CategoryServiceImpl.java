package com.kunlun.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.CategoryClient;
import com.kunlun.api.service.CategoryService;
import com.kunlun.entity.Category;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     *新增类目
     *
     * @param category
     * @return
     */
    @Override
    public DataRet<String> add(Category category) {
        return categoryClient.addCategory(category);
    }

    /**
     * 修改类目
     *
     * @param category
     * @return
     */
    @Override
    public DataRet<String> modify(Category category) {
        return categoryClient.modify(category);
    }


    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<Category> findById(Long id) {
        return categoryClient.findById(id);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return categoryClient.deleteById(id);
    }

    /**
     * 修改状态
     *
     * @param status
     * @param id
     * @return
     */
    @Override
    public DataRet<String> updateStatus(String status, Long id) {
        return categoryClient.updateStatus(status,id);
    }

    /**
     * 分页
     *
     * @param pageNo
     * @param pageSize
     * @param type
     * @param searchKey
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String type, String searchKey) {
        return categoryClient.findByCondition(pageNo,pageSize,type,searchKey);
    }

    /**
     * 批量绑定
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> bindBatch(JSONObject jsonObject) {
        return categoryClient.bindBatch(jsonObject);
    }


    /**
     * 批量解绑
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> unbindBatch(JSONObject jsonObject) {
        return categoryClient.unbindBatch(jsonObject);
    }


}
