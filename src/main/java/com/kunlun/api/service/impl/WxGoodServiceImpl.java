package com.kunlun.api.service.impl;

import com.kunlun.api.client.WxGoodClient;
import com.kunlun.api.service.WxGoodService;
import com.kunlun.entity.GoodSnapshot;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hws
 * @created on 2017/12/26.
 */
@Service
public class WxGoodServiceImpl implements WxGoodService{
    @Autowired
    private WxGoodClient wxGoodClient;

    /**
     * 商品详情
     *
     * @param id Long
     * @return Good
     */
    @Override
    public DataRet findById(Long id) {
        return wxGoodClient.findById(id);
    }

    /**
     * 查询商品评价列表
     *
     * @param pageNo   Integer
     * @param pageSize Integer
     * @param goodId   Long
     * @return List
     */
    @Override
    public PageResult findEstimateList(Integer pageNo, Integer pageSize, Long goodId) {
        return wxGoodClient.findEstimateList(pageNo,pageSize,goodId);
    }

    /**
     * 商品搜索
     *
     * @param pageNo     Integer
     * @param pageSize   Integer
     * @param categoryId Long
     * @param searchKey  String
     * @return List
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long categoryId, String searchKey) {
        return wxGoodClient.findByCondition(pageNo,pageSize,categoryId,searchKey);
    }

    /**
     * 获取商品快照详情
     *
     * @param orderId Long
     * @return DataRet
     */
    @Override
    public DataRet findGoodSnapshot(Long orderId) {
        return wxGoodClient.findGoodSnapshot(orderId);
    }

}
