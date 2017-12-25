package com.kunlun.api.service;

import com.kunlun.api.hystrix.GoodServiceHystrix;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-21.
 */
@FeignClient(value = "cloud-service-good",fallback = GoodServiceHystrix.class)
public interface GoodService {


    /**
     * 商品创建
     *
     * @param good
     * @return
     */
    @PostMapping("/backstage/good/add")
    DataRet<String> add(@RequestBody Good good);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @GetMapping("/backstage/good/findById")
    DataRet<Good> findById(@RequestParam(value = "id") Long id);

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
    PageResult findByCondition(@RequestParam(value = "page_no") Integer pageNo,
                               @RequestParam(value = "page_size") Integer pageSize,
                               @RequestParam(value = "search_key",required = false) String searchKey,
                               @RequestParam(value = "good_no",required = false) String goodNo,
                               @RequestParam(value = "start_date",required = false) Date startDate,
                               @RequestParam(value = "end_date",required = false) Date endDate,
                               @RequestParam(value = "brand_id",required = false) Long brandId,
                               @RequestParam(value = "on_sale",required = false) String onSale,
                               @RequestParam(value = "category_id",required = false) Long categoryId,
                               @RequestParam(value = "hot",required = false) String hot,
                               @RequestParam(value = "is_new",required = false) String isNew,
                               @RequestParam(value = "freight",required = false) String freight);


    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @PostMapping("/backstage/good/deleteById")
    DataRet<String> deleteById(@RequestParam(value = "id") Long id);
}
