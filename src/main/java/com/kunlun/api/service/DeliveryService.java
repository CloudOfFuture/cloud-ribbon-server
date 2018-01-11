package com.kunlun.api.service;


import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
public interface DeliveryService {

    /**
     * 根据id查找收获地址详情
     *
     * @param id
     * @return
     */
    DataRet<Delivery> findById(Long id);


    /**
     * 用户收货地址分页
     *
     * @param wxCode
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult findByUserId(String wxCode, Long userId, Integer pageNo, Integer pageSize);


    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    DataRet<String> add(Delivery delivery);


    /**
     * 修改收货地址
     *
     * @param delivery
     * @return
     */
    DataRet<String> update(Delivery delivery);

    /**
     * 删除收货地址
     *
     * @param id
     * @return
     */
    DataRet<String> deleteById(Long id);


    /**
     * 设置默认地址
     *
     * @param id
     * @param wxCode
     * @return
     */
    DataRet<String> defaultAddress(Long id, String wxCode, Long userId);

    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    DataRet<Delivery> getDefault(String wxCode, Long userId);
}
