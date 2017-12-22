package com.kunlun.api.service;

import com.kunlun.api.hystrix.WxGoodServiceHystrix;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-22下午4:52
 * @desc
 */
@FeignClient(value = "cloud-service-good", fallback = WxGoodServiceHystrix.class)
public interface WxGoodService {

    /**
     * 商品详情
     *
     * @param goodId Long
     * @return Good
     */
    @GetMapping("wx/good/findById")
    DataRet findById(@RequestParam("goodId") Long goodId);

    /**
     * 查询商品评价列表
     *
     * @param pageNo   Integer
     * @param pageSize Integer
     * @param goodId   Long
     * @return List
     */
    @GetMapping("wx/good/findEstimateList")
    PageResult findEstimateList(@RequestParam("pageNo") Integer pageNo,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("goodId") Long goodId);

    /**
     * 商品搜索
     *
     * @param pageNo     Integer
     * @param pageSize   Integer
     * @param categoryId Long
     * @param searchKey  String
     * @return List
     */
    @GetMapping("wx/good/findByCondition")
    PageResult findByCondition(@RequestParam("pageNo") Integer pageNo,
                               @RequestParam("pageSize") Integer pageSize,
                               @RequestParam(value = "categoryId", required = false) Long categoryId,
                               @RequestParam(value = "searchKey", required = false)
                                       String searchKey);

    /**
     * 获取商品快照详情
     *
     * @param orderId Long
     * @return DataRet
     */
    @GetMapping("wx/good/findGoodSnapshot")
    DataRet findGoodSnapshot(@RequestParam("orderId") Long orderId);
}
