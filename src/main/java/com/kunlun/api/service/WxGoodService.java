package com.kunlun.api.service;

import com.kunlun.api.hystrix.WxGoodClientHystrix;
import com.kunlun.entity.GoodSnapshot;
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
public interface WxGoodService {

    /**
     * 商品详情
     *
     * @param id Long
     * @return Good
     */
    DataRet findById(Long id);

    /**
     * 查询商品评价列表
     *
     * @param pageNo   Integer
     * @param pageSize Integer
     * @param goodId   Long
     * @return List
     */
    PageResult findEstimateList(Integer pageNo,
                                Integer pageSize,
                                 Long goodId);

    /**
     * 商品搜索
     *
     * @param pageNo     Integer
     * @param pageSize   Integer
     * @param categoryId Long
     * @param searchKey  String
     * @return List
     */
    PageResult findByCondition(Integer pageNo,
                               Integer pageSize,
                               Long categoryId, String searchKey);

    /**
     * 获取商品快照详情
     *
     * @param orderId Long
     * @return DataRet
     */
    DataRet findGoodSnapshot(Long orderId);



}
