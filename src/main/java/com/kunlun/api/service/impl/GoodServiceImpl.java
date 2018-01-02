package com.kunlun.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.GoodClient;
import com.kunlun.api.service.GoodService;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private GoodClient goodClient;

    /**
     * 商品创建
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> add(JSONObject jsonObject) {
        return goodClient.add(jsonObject);
    }

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<Good> findById(Long id) {
        return goodClient.findById(id);
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
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey, String goodNo,
                                      Date startDate, Date endDate, Long brandId, String onSale, Long categoryId,
                                      String hot, String isNew, String freight) {
        return goodClient.findByCondition(pageNo,pageSize,searchKey,goodNo,startDate,endDate,brandId,onSale,categoryId,hot,isNew,freight);
    }

    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return goodClient.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    @Override
    public DataRet<String> deleteByIdList(List<Long> idList) {
        return goodClient.deleteByIdList(idList);
    }

    /**
     * 修改商品信息
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> update(JSONObject jsonObject) {
        return goodClient.update(jsonObject);
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
        return goodClient.updateSaleStatus(onSale,id);
    }

    /**
     * 商品批量上下架
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> updateSaleList(JSONObject jsonObject) {
        return goodClient.updateSaleList(jsonObject);
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
        return goodClient.audit(audit,reason,id);
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
        return updateStock(id,count);
    }
}
