package com.kunlun.api.client;

import com.kunlun.api.hystrix.BrandClientHystrix;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
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
    DataRet modify(Brand brand);

    /**
     * 根据id查询品牌详情
     *
     * @param id
     * @return
     */
    @GetMapping("/brand/findBrandById")
    DataRet findBrandById(@RequestParam(value = "id") Integer id);
}
