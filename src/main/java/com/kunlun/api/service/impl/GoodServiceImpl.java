package com.kunlun.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.service.GoodService;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@Service
public class GoodServiceImpl implements GoodService {
    /**
     * 商品创建
     *
     * @param good
     * @return
     */
    @Override
    public DataRet<String> add(Good good) {
        return null;
    }

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<Good> findById(Long id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @param goodNo
     * @param startDate
     * @param endDate
     * @param brandId
     * @param onSale
     * @param categoryId
     * @param hot
     * @param isNew
     * @param freight
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey, String goodNo, Date startDate, Date endDate, Long brandId, String onSale, Long categoryId, String hot, String isNew, String freight) {
        return null;
    }

    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return null;
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    @Override
    public DataRet<String> deleteByIdList(List<Long> idList) {
        return null;
    }

    /**
     * 修改商品信息
     *
     * @param good
     * @return
     */
    @Override
    public DataRet<String> update(Good good) {
        return null;
    }

    /**
     * 商品上下架
     *
     * @param onSale
     * @param id
     * @return
     */
    @Override
    public DataRet<String> updateSaleStatus(String onSale, Long id) {
        return null;
    }

    /**
     * 商品批量上下架
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> updateSaleList(JSONObject jsonObject) {
        return null;
    }

    /**
     * 新建商品审核
     *
     * @param audit
     * @param reason
     * @param id
     * @return
     */
    @Override
    public DataRet<String> audit(String audit, String reason, Long id) {
        return null;
    }

    /**
     * 修改商品库存
     *
     * @param id
     * @param count
     * @return
     */
    @Override
    public DataRet<String> updateStock(Long id, Integer count) {
        return null;
    }
}
