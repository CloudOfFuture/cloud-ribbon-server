package com.kunlun.api.client;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.BrandClientHystrix;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-02.
 */
@FeignClient(value = "cloud-service-common", fallback = BrandClientHystrix.class)
public interface BrandClient {

    /**
     * 增加品牌
     *
     * @param brand
     * @return
     */
    @PostMapping("/brand/add")
    DataRet add(@RequestBody Brand brand);

    /**
     * 修改品牌
     *
     * @param brand
     * @return
     */
    @PostMapping("/brand/modify")
    DataRet modify(@RequestBody Brand brand);

    /**
     * 根据id查询品牌详情
     *
     * @param id
     * @return
     */
    @GetMapping("/brand/findBrandById")
    DataRet findBrandById(@RequestParam(value = "id") Integer id);

    /**
     * 分页查询品牌详情/模糊查询
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @GetMapping("/brand/findByCondition")
    PageResult findByCondition(
            @RequestParam(value = "pageNo") Integer pageNo,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "searchKey") String searchKey);

    /**
     * 批量删除品牌状态
     *
     * @param object
     * @return
     */
    @PostMapping("/brand/batchModifyStatus")
    DataRet batchModifyStatus(@RequestBody JSONObject object);

    Long l=140L;
    Integer i =212;
}
