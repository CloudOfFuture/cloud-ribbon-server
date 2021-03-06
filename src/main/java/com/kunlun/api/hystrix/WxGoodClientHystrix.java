package com.kunlun.api.hystrix;

import com.kunlun.api.client.WxGoodClient;
import com.kunlun.entity.GoodSnapshot;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by hws
 * @created on 2017/12/26.
 */
@Component
public class WxGoodClientHystrix implements WxGoodClient{
    /**
     * 商品详情
     *
     * @param id Long
     * @return Good
     */
    @Override
    public DataRet findById(Long id) {return new DataRet<>("not_found", "暂无数据");}

    /**
     * 查询商品评价列表
     *
     * @param pageNo   Integer
     * @param pageSize Integer
     * @param goodId   Long
     * @return List
     */
    @Override
    public PageResult findEstimateList(Integer pageNo, Integer pageSize, Long goodId)  {
        return new PageResult<>();
    }

    /**
     * 商品搜索
     *
     * @param pageNo     Integer
     * @param pageSize   Integer
     * @param categoryId Long
     * @param searchKey  String
     * @return List
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long categoryId, String searchKey) {
        return new PageResult<>();
    }

    /**
     * 获取商品快照详情
     *
     * @param orderId Long
     * @return DataRet
     */
    @Override
    public DataRet findGoodSnapshot(Long orderId)  {
        return new DataRet<>("not_found", "暂无数据");
    }

}
