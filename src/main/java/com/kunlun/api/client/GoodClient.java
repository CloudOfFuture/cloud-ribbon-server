package com.kunlun.api.client;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.GoodClientHystrix;
import com.kunlun.entity.Good;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@FeignClient(value = "cloud-service-good",fallback = GoodClientHystrix.class)
public interface GoodClient {


    /**
     * 商品创建
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/backstage/good/add")
    DataRet<String> add(@RequestBody JSONObject jsonObject);

    /**
     * 获取商品详情
     *
     * @param goodId
     * @return
     */
    @GetMapping("/backstage/good/findById")
    DataRet<GoodExt> findById(@RequestParam(value = "goodId") Long goodId);

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
    @GetMapping("/backstage/good/findByCondition")
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "sellerId") Long sellerId,
                               @RequestParam(value = "type") String type,
                               @RequestParam(value = "searchKey",required = false) String searchKey,
                               @RequestParam(value = "goodNo",required = false) String goodNo,
                               @RequestParam(value = "startDate",required = false) Date startDate,
                               @RequestParam(value = "endDate",required = false) Date endDate,
                               @RequestParam(value = "brandId",required = false) Long brandId,
                               @RequestParam(value = "onSale",required = false) String onSale,
                               @RequestParam(value = "categoryId",required = false) Long categoryId,
                               @RequestParam(value = "hot",required = false) String hot,
                               @RequestParam(value = "isNew",required = false) String isNew,
                               @RequestParam(value = "freight",required = false) String freight);


    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @PostMapping("/backstage/good/deleteById")
    DataRet<String> deleteById(@RequestParam(value = "id") Long id);

    /**
     * 批量删除
     *
     * @param object
     * @return
     */
    @PostMapping("/backstage/good/deleteByIdList")
    DataRet<String> deleteByIdList(@RequestBody JSONObject object);


    /**
     * 修改商品信息
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/backstage/good/update")
    DataRet<String> update(@RequestBody JSONObject jsonObject);


    /**
     * 商品上下架
     *
     * @param onSale
     * @param id
     * @return
     */
    @GetMapping("/backstage/good/updateSaleStatus")
    DataRet<String> updateSaleStatus(@RequestParam(value = "onSale") String onSale,
                                     @RequestParam(value = "id") Long id);


    /**
     * 商品批量上下架
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/backstage/good/updateSaleList")
    DataRet<String> updateSaleList(@RequestBody JSONObject jsonObject);


    /**
     * 新建商品审核
     *
     * @param audit
     * @param reason
     * @param id
     * @return
     */
    @PostMapping("/backstage/good/audit")
    DataRet<String> audit(@RequestParam(value = "audit") String audit,
                          @RequestParam(value = "reason",required = false) String reason,
                          @RequestParam(value = "id") Long id);


    /**
     * 修改商品库存
     *
     * @param id
     * @param count
     * @return
     */
    @PostMapping("/backstage/good/updateStock")
    DataRet<String> updateStock(@RequestParam(value = "id") Long id,
                                @RequestParam(value = "count") Integer count);



    /**
     * 商品销量
     *
     * @param count
     * @param goodId
     * @return
     */
    @PostMapping("/backstage/good/updateSaleVolume")
     DataRet<String> updateSaleVolume(@RequestParam(value = "count") Integer count,
                                            @RequestParam(value = "goodId") Long goodId);
}
