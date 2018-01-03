package com.kunlun.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.service.BrandService;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
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

    /**
     * 分页查询品牌详情/模糊查询
     *
     * @param pageNo    页码
     * @param pageSize  数量
     * @param searchKey 关键字
     * @return
     */
    @GetMapping("/findByCondition")
    public PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                                      @RequestParam(value = "pageSize") Integer pageSize,
                                      @RequestParam(value = "searchKey") String searchKey) {
        return brandService.findByCondition(pageNo, pageSize, searchKey);
    }

    /**
     * 批量删除品牌状态
     *
     * @param object 对象
     * @return
     */
    @PostMapping(value = "/batchModifyStatus")
    public DataRet batchModifyStatus(@RequestBody JSONObject object) {
        return brandService.batchModifyStatus(object);
    }

}
