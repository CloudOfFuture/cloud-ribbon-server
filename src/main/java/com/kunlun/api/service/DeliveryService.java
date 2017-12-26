package com.kunlun.api.service;


import com.kunlun.result.DataRet;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
public interface DeliveryService {

    /**
     * 根据id查找收获地址详情
     * @param id
     * @return
     */
    DataRet findById(Long id);

    /**
     * 根据id校验收获地址
     * @param id
     * @return
     */
    String check(Long id);

}
