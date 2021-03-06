package com.kunlun.api.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.GoodClient;
import com.kunlun.entity.Good;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-21.
 */
@Component
public class GoodClientHystrix implements GoodClient {
    /**
     * 创建失败
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> add(JSONObject jsonObject) {
        return new DataRet<>("ERROR","创建失败");
    }

    /**
     * 获取商品详情
     *
     * @param goodId
     * @return
     */
    @Override
    public DataRet<GoodExt> findById(Long goodId) {
        return new DataRet<>("ERROR","未找到");
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
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long sellerId, String type,
                                      String searchKey, String goodNo, Date startDate, Date endDate,
                                      Long brandId, String onSale, Long categoryId, String hot,
                                      String isNew, String freight) {
        return new  PageResult("ERROR","分页失败");
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return new DataRet<>("ERROR","删除失败");
    }


    /**
     * 批量删除商品
     *
     * @param object
     * @return
     */
    @Override
    public DataRet<String> deleteByIdList(JSONObject object) {
        return new DataRet<>("ERROR","批量删除失败");
    }


    /**
     * 修改商品信息
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> update(JSONObject jsonObject) {
        return new DataRet<>("ERROR","修改商品信息失败");
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
        return new DataRet<>("ERROR","商品上下架失败");
    }


    /**
     * 商品批量上下架
     *
     * @param jsonObject
     * @return
     */
    @Override
    public DataRet<String> updateSaleList(JSONObject jsonObject) {
        return new DataRet<>("ERROR","商品批量上下架失败");
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
        return new DataRet<>("ERROR","审核失败");
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
        return new DataRet<>("ERROR","修改库存失败");
    }


    /**
     * 商品销量
     *
     * @param count
     * @param goodId
     * @return
     */
    @Override
    public DataRet<String> updateSaleVolume(Integer count, Long goodId) {
        return new DataRet<>("ERROR","销量更改失败");
    }


}
