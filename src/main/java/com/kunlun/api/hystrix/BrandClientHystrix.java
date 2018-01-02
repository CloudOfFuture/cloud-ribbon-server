package com.kunlun.api.hystrix;

import com.kunlun.api.client.BrandClient;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-02.
 */
@Component
public class BrandClientHystrix implements BrandClient {

    /**
     * 增加品牌
     *
     * @param brand
     * @return
     */
    @Override
    public DataRet add(Brand brand) {
        return new DataRet("ERROR", "增加失败");
    }

    /**
     * 修改品牌
     *
     * @param brand
     * @return
     */
    @Override
    public DataRet modify(Brand brand) {
        return new DataRet("ERROR", "修改失败");
    }

    /**
     * 根据id查询品牌详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet findBrandById(Integer id) {
        return new DataRet("ERROR", "查询品牌详情失败");
    }

    /**
     * 分页查询品牌详情/模糊查询
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return new PageResult("ERROR", "模糊查询失败");
    }
}
