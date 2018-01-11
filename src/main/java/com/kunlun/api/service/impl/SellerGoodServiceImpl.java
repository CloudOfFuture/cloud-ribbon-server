package com.kunlun.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.SellerGoodClient;
import com.kunlun.api.service.SellerGoodService;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-10.
 */
@Service
public class SellerGoodServiceImpl implements SellerGoodService{

    @Autowired
    private SellerGoodClient sellerGoodClient;


    /**
     * 商户新增商品
     *
     * @param object JSONObject
     * @return
     */
    @Override
    public DataRet add(JSONObject object) {
        return sellerGoodClient.add(object);
    }

    /**
     *获取商品详情
     *
     * @param id Long
     * @return
     */
    @Override
    public DataRet<GoodExt> findById(Long id) {
        return sellerGoodClient.findById(id);
    }

    /**
     *修改商品
     *
     * @param object JSONObject
     * @return
     */
    @Override
    public DataRet updateGood(JSONObject object) {
        return sellerGoodClient.updateGood(object);
    }


    /**
     *分页查询
     *
     * @param pageNo     Integer
     * @param pageSize   Integer
     * @param userId     Long
     * @param type       UNBIND_CATEGORY 未绑定类目
     *                   UNBIND_ACTIVITY 未绑定活动
     *                   BIND_ACTIVITY 已经绑定活动
     * @param searchKey  String
     * @param goodNo     String
     * @param startDate  String
     * @param endDate    String
     * @param brandId    Long
     * @param saleStatus String
     * @param categoryId Long
     * @param hot        String
     * @param isNew      String
     * @param freight    String
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long userId, String type,
                                      String searchKey, String goodNo, String startDate, String endDate,
                                      Long brandId, String saleStatus, Long categoryId, String hot, String isNew, String freight) {
        return sellerGoodClient.findByCondition(pageNo,pageSize,userId,type,searchKey,goodNo,startDate,endDate,brandId,saleStatus,
                                                categoryId,hot,isNew,freight);
    }

    /**
     *批量删除
     *
     * @param jsonArray 商品id集合
     * @return
     */
    @Override
    public DataRet deleteByIdList(JSONArray jsonArray) {
        return sellerGoodClient.deleteByIdList(jsonArray);
    }


    /**
     *修改商品库存
     *
     * @param id    商品id--主键
     * @param count 扣减、增加数量
     * @return
     */
    @Override
    public DataRet updateGoodStock(Long id, Integer count) {
        return sellerGoodClient.updateGoodStock(id,count);
    }

    /**
     *
     *
     * @param object
     * @return
     */
    @Override
    public DataRet batchUpdateSaleStatus(JSONObject object) {
        return sellerGoodClient.batchUpdateSaleStatus(object);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public DataRet delete(Long id) {
        return sellerGoodClient.delete(id);
    }
}
