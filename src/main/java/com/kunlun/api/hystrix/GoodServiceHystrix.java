package com.kunlun.api.hystrix;

import com.kunlun.api.service.GoodService;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-21.
 */
@Component
public class GoodServiceHystrix implements GoodService {


    /**
     * 创建失败
     *
     * @param good
     * @return
     */
    @Override
    public DataRet<String> add(Good good) {
        return new DataRet<>("ERROR","创建失败");
    }

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<Good> findById(Long id) {
        return new DataRet<>("ERROR","未找到");
    }

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
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey, String goodNo, Date startDate,
                                      Date endDate, Long brandId, String onSale, Long categoryId, String hot,
                                      String isNew, String freight) {
        return new PageResult();
    }


    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return new DataRet<>("ERROR","删除失败");
    }


    /**
     * 批量删除商品
     *
     * @param idList
     * @return
     */
    @Override
    public DataRet<String> deleteByIdList(List<Long> idList) {
        return new DataRet<>("ERROR","批量删除失败");
    }


    /**
     * 修改商品信息
     *
     * @param good
     * @return
     */
    @Override
    public DataRet<String> update(Good good) {
        return new DataRet<>("ERROR","修改商品信息失败");
    }


    /**
     * 商品上下架
     *
     * @param onSale
     * @param id
     * @return
     */
    @Override
    public DataRet<String> updateSaleStatus(String onSale, Long id) {
        return new DataRet<>("ERROR","商品上下架失败");
    }


    /**
     * 商品批量上下架
     *
     * @param onSale
     * @param goodIdList
     * @return
     */
    @Override
    public DataRet<String> updateSaleList(String onSale, List<Long> goodIdList) {
        return new DataRet<>("ERROR","商品批量上下架失败");
    }


    /**
     * 新建商品审核
     *
     * @param audit
     * @param reason
     * @param id
     * @return
     */
    @Override
    public DataRet<String> audit(String audit, String reason, Long id) {
        return new DataRet<>("ERROR","审核失败");
    }


    /**
     * 修改商品库存
     *
     * @param id
     * @param count
     * @return
     */
    @Override
    public DataRet<String> updateStock(Long id, Integer count) {
        return new DataRet<>("ERROR","修改库存失败");
    }


}
