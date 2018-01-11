package com.kunlun.api.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.service.SellerGoodService;
import com.kunlun.entity.GoodExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-25上午9:52
 * @desc
 */

@RestController
@RequestMapping("seller/good")
public class SellerGoodController {

    @Autowired
    private SellerGoodService sellerGoodService;

    /**
     * 创建商品
     *
     * @param object
     * @return
     */
    @PostMapping(value = "/add")
    public DataRet add(@RequestBody JSONObject object) {
        return sellerGoodService.add(object);
    }

    /**
     * 修改商品
     *
     * @param object
     * @return
     */
    @PostMapping(value = "/update")
    public DataRet updateGood(@RequestBody JSONObject object) {
        return sellerGoodService.updateGood(object);
    }



    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public DataRet delete(@RequestParam(value = "id") Long id){
        return sellerGoodService.delete(id);
    }


    /**
     * 批量删除商品
     *
     * @return DataRet
     */
    @PostMapping(value = "/deleteByIdList")
    public DataRet deleteByIdList(@RequestBody JSONArray jsonArray) {
        return sellerGoodService.deleteByIdList(jsonArray);
    }

    /**
     * 根据商品id查询商品
     *
     * @param id 商品id
     * @return
     */
    @GetMapping(value = "/findById")
    public DataRet<GoodExt> findById(@RequestParam(value = "id") Long id) {
        return sellerGoodService.findById(id);
    }

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
    @GetMapping(value = "/findByCondition")
    public PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
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
                                      @RequestParam(value = "freight", required = false) String freight) {
        return sellerGoodService.findByCondition(pageNo, pageSize, userId, type, searchKey, goodNo,
                startDate, endDate, brandId, saleStatus, categoryId, hot, isNew, freight);
    }

    /**
     * 批量商品上下架
     *
     * @param object
     * @return
     */
    @PostMapping(value = "/batchUpdateSaleStatus")
    public DataRet batchUpdateSaleStatus(@RequestBody JSONObject object) {
        return sellerGoodService.batchUpdateSaleStatus(object);
    }

    /**
     * 商品库存修改
     *
     * @param count 数量  小于0 扣减，大于0 增加库存
     * @param id    商品id，主键
     * @return
     */
    @PostMapping(value = "/updateGoodStock")
    public DataRet updateGoodStock(@RequestParam(value = "id") Long id,
                                   @RequestParam(value = "count") Integer count) {
        return sellerGoodService.updateGoodStock(id, count);
    }
}
