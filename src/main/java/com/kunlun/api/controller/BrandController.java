package com.kunlun.api.controller;

import com.kunlun.api.service.BrandService;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-02.
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 增加品牌
     *
     * @param brand 品牌
     * @return
     */
    @PostMapping("/add")
    public DataRet add(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    /**
     * 修改品牌
     *
     * @param brand 品牌
     * @return
     */
    @PostMapping("/modify")
    public DataRet modify(@RequestBody Brand brand) {
        return brandService.modify(brand);
    }

    /**
     * 根据id查询品牌详情
     *
     * @param id
     * @return
     */
    @GetMapping("/findBrandById")
    public DataRet findBrandById(@RequestParam(value = "id") Integer id) {
        return brandService.findBrandById(id);
    }
}
