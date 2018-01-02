package com.kunlun.api.service.impl;

import com.kunlun.api.client.BrandClient;
import com.kunlun.api.service.BrandService;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-02.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandClient brandClient;

    /**
     * 增加品牌
     *
     * @param brand
     * @return
     */
    @Override
    public DataRet add(Brand brand) {
        return brandClient.add(brand);
    }

    /**
     * 修改品牌
     *
     * @param brand
     * @return
     */
    @Override
    public DataRet modify(Brand brand) {
        return brandClient.modify(brand);
    }

    /**
     * 根据id查询品牌详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet findBrandById(Integer id) {
        return brandClient.findBrandById(id);
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
        return brandClient.findByCondition(pageNo, pageSize, searchKey);
    }
}
