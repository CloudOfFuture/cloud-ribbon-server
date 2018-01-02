package com.kunlun.api.client;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.CategoryClientHystrix;
import com.kunlun.entity.Category;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-27.
 */
@FeignClient(value = "cloud-service-common",fallback = CategoryClientHystrix.class)
public interface CategoryClient {

    /**
     * 商品绑定类目
     *
     * @param categoryId
     * @param goodId
     * @return
     */
    @PostMapping("/category/bindCategoryGood")
     DataRet<String> bind(@RequestParam(value = "categoryId") Long categoryId,
                                @RequestParam(value = "goodId") Long goodId);


    /**
     * 商品解绑类目
     *
     * @param goodId
     * @return
     */
    @PostMapping("/category/unbindCategoryGood")
     DataRet<String> unbinding(@RequestParam(value = "goodId") Long goodId);

    /**
     * 新增类目
     *
     * @param category
     * @return
     */
    @PostMapping("/category/add/category")
     DataRet<String> addCategory(@RequestBody Category category) ;


    /**
     * 修改类目
     *
     * @param category Category
     * @return
     */
    @PostMapping("/category/modify")
     DataRet<String> modify(@RequestBody Category category);


    /**
     * 查询详情
     *
     * @param id Long
     * @return
     */
    @GetMapping("/category/findById")
     DataRet<Category> findById(@RequestParam(value = "id") Long id) ;


    /**
     * 删除类目
     *
     * @param id Long
     * @return
     */
    @PostMapping("/category/deleteById")
     DataRet<String> deleteById(@RequestParam(value = "id") Long id);

    /**
     * 修改类目状态
     * 状态 NORMAL UN_NORMAL
     *
     * @return
     */
    @PostMapping("/category/updateStatus")
     DataRet<String> updateStatus(@RequestParam(value = "status") String status,@RequestParam("id") Long id);

    /**
     * 列表查询
     *
     * @param pageNo    页码
     * @param pageSize  数量
     * @param searchKey 模糊查询信息
     * @param type      PARENT CHILD
     * @return
     */
    @GetMapping("/category/findByCondition")
     PageResult findByCondition(@RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize") Integer pageSize,
                                      @RequestParam(value = "type",required = false) String type,
                                      @RequestParam(value = "searchKey",required = false) String searchKey);

    /**
     * 商品批量绑定类目
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/category/bindBatch")
     DataRet<String> bindBatch(@RequestBody JSONObject jsonObject);


    /**
     * 商品批量解绑
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/category/unbindBatch")
     DataRet<String> unbindBatch(@RequestBody JSONObject jsonObject);
}
