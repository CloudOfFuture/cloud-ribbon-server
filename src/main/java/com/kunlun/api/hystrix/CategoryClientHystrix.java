package com.kunlun.api.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.CategoryClient;
import com.kunlun.entity.Category;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-27.
 */
@Component
public class CategoryClientHystrix implements CategoryClient{

    /**
     * 商品绑定类目
     *
     * @param categoryId
     * @param goodId
     * @return
     */
    @Override
    public DataRet<String> bind(Long categoryId, Long goodId) {
        return new DataRet<>("ERROR","绑定失败");
    }


    /**
     * 商品解绑类目
     *
     * @param goodId
     * @return
     */
    @Override
    public DataRet<String> unbinding(Long goodId) {
        return new DataRet<>("ERROR","解绑失败");
    }

    /**
     * 新增类目失败回调
     *
     * @param category
     * @return
     */
    @Override
    public DataRet<String> addCategory(Category category) {
        return new DataRet<>("ERROR","新增失败");
    }

    /**
     * 修改类目
     *
     * @param category Category
     * @return
     */
    @Override
    public DataRet<String> modify(Category category) {
        return new DataRet<>("ERROR","修改失败");
    }

    /**
     * 获取详情
     *
     * @param id Long
     * @return
     */
    @Override
    public DataRet<Category> findById(Long id) {
        return new DataRet<>("ERROR","获取失败");
    }

    /**
     * 删除类目
     *
     * @param id Long
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return new DataRet<>("ERROR","删除失败");
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
        return new DataRet<>("ERROR","修改状态失败");
    }

    /**
     * 分页
     *
     * @param pageNo    页码
     * @param pageSize  数量
     * @param type      PARENT CHILD
     * @param searchKey 模糊查询信息
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String type, String searchKey) {
        return new PageResult("ERROR","分页失败");
    }

    /**
     * 批量绑定
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> bindBatch(JSONObject jsonObject) {
        return new DataRet<>("ERROR","批量绑定失败");
    }

    /**
     * 批量解绑
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> unbindBatch(JSONObject jsonObject) {
        return new DataRet<>("ERROR","批量解绑失败");
    }
}
