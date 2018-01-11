package com.kunlun.api.hystrix;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.SellerClient;
import com.kunlun.api.client.SellerGoodClient;
import com.kunlun.api.service.SellerGoodService;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-25上午9:54
 * @desc
 */
@Component
public class SellerGoodServiceHystrix implements SellerGoodClient{


    /**
     * 商品新增
     *
     * @param object
     * @return
     */
    @Override
    public DataRet<String> add(JSONObject object) {
        return new DataRet<>("ERROR", "商户新增商品接口出错");
    }

    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @return
     */
    @Override
    public DataRet<GoodExt> findById(Long id) {
        return new DataRet<>("ERROR", "暂无数据");
    }

    /**
     * 商户商品修改
     *
     * @param object
     * @return
     */
    @Override
    public DataRet updateGood(JSONObject object) {
        return new DataRet<>("ERROR", "修改失败");
    }

    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @Override
    public DataRet delete(Long id) {
        return new DataRet("ERROR","商户根据id删除商品接口出错");
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
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long userId, String type, String searchKey, String goodNo, String startDate, String endDate, Long brandId, String saleStatus, Long categoryId, String hot, String isNew, String freight) {
        return new PageResult("ERROR","商户分页查询接口出错");
    }

    /**
     *批量删除
     *
     * @param jsonArray
     * @return
     */
    @Override
    public DataRet deleteByIdList(JSONArray jsonArray) {
        return new DataRet<>("ERROR", "删除失败");
    }

    /**
     *修改库存
     *
     * @param id    商品id，主键
     * @param count 数量  小于0 扣减，大于0 增加库存
     * @return
     */
    @Override
    public DataRet updateGoodStock(Long id, Integer count) {
        return new DataRet<>("ERROR", "修改失败");
    }

    /**
     *
     *
     * @param object
     * @return
     */
    @Override
    public DataRet batchUpdateSaleStatus(JSONObject object) {
        return new DataRet<>("ERROR", "修改失败");
    }
}
