package com.kunlun.api.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-25上午9:54
 * @desc
 */
public interface SellerGoodService {
    /**
     * 创建商品
     *
     * @param object JSONObject
     * @return JSONObject
     */
    DataRet add(JSONObject object);


    /**
     * 根据id查询商品详情
     *
     * @param id Long
     * @return JSONObject
     */
    DataRet<GoodExt> findById(Long id);

    /**
     * 根据id修改商品信息
     *
     * @param object JSONObject
     * @return JSONObject
     */
    DataRet updateGood(JSONObject object);


    /**
     * 条件查询商品列表
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
     * @return List
     */
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "userId") Long userId,
                               @RequestParam(value = "type") String type,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "goodNo", required = false) String goodNo,
                               @RequestParam(value = "startDate", required = false) String startDate,
                               @RequestParam(value = "endDate", required = false) String endDate,
                               @RequestParam(value = "brandId", required = false) Long brandId,
                               @RequestParam(value = "saleStatus", required = false) String saleStatus,
                               @RequestParam(value = "categoryId", required = false) Long categoryId,
                               @RequestParam(value = "hot", required = false) String hot,
                               @RequestParam(value = "isNew", required = false) String isNew,
                               @RequestParam(value = "freight", required = false) String freight);

    /**
     * 批量删除商品
     *
     * @param jsonArray 商品id集合
     * @return JSONObject
     */
    DataRet deleteByIdList( JSONArray jsonArray);

    /**
     * 商品库存减扣
     *
     * @param id    商品id--主键
     * @param count 扣减、增加数量
     * @return DataRet
     */
    DataRet updateGoodStock( Long id, Integer count);

    /**
     * 批量商品上下架
     *
     * @return JSONObject
     */
    DataRet batchUpdateSaleStatus(JSONObject object);


    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    DataRet delete(Long id);
}
