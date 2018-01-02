package com.kunlun.api.service;

import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-02.
 */
public interface BrandService {

    /**
     * 增加品牌
     *
     * @param brand
     * @return
     */
    DataRet add(Brand brand);

    /**
     * 修改品牌
     *
     * @param brand
     * @return
     */
    DataRet modify(Brand brand);

    /**
     * 根据id查询品牌详情
     *
     * @param id
     * @return
     */
    DataRet findBrandById(Integer id);
}
