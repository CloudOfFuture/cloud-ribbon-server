package com.kunlun.api.hystrix;

import com.kunlun.api.service.GoodService;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

import java.util.Date;

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
}
