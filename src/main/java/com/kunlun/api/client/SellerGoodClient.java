package com.kunlun.api.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.SellerGoodServiceHystrix;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-10.
 */
@FeignClient(value = "cloud-service-good",fallback = SellerGoodServiceHystrix.class)
public interface SellerGoodClient {


    /**
     * 创建商品
     *
     * @param object
     * @return
     */
    @PostMapping(value = "/seller/good/add")
     DataRet add(@RequestBody JSONObject object);


    /**
     * 修改商品
     *
     * @param object
     * @return
     */
    @PostMapping(value = "/seller/good/update")
     DataRet updateGood(@RequestBody JSONObject object);


    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @PostMapping("/seller/good/delete")
     DataRet delete(@RequestParam(value = "id") Long id);

    /**
     * 批量删除商品
     *
     * @return DataRet
     */
    @PostMapping(value = "/seller/good/deleteByIdList")
     DataRet deleteByIdList(@RequestBody JSONArray jsonArray);


    /**
     * s
     * 根据商品id查询商品
     *
     * @param id 商品id
     * @return
     */
    @GetMapping(value = "/seller/good/findById")
     DataRet<GoodExt> findById(@RequestParam(value = "id") Long id);


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
    @GetMapping(value = "/seller/good/findByCondition")
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
                                      @RequestParam(value = "freight", required = false) String freight) ;



    /**
     * 批量商品上下架
     *
     * @param object
     * @return
     */
    @PostMapping(value = "/seller/good/batchUpdateSaleStatus")
     DataRet batchUpdateSaleStatus(@RequestBody JSONObject object);


    /**
     * 商品库存修改
     *
     * @param count 数量  小于0 扣减，大于0 增加库存
     * @param id    商品id，主键
     * @return
     */
    @PostMapping(value = "/seller/good/updateGoodStock")
     DataRet updateGoodStock(@RequestParam(value = "id") Long id,
                                   @RequestParam(value = "count") Integer count);
}
