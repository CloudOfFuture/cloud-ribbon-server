package com.kunlun.api.service.impl;

import com.kunlun.api.client.DeliveryClient;
import com.kunlun.api.service.DeliveryService;
import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryClient deliveryClient;

    /**
     * 根据id查找收获地址详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<Delivery> findById(Long id) {
        return deliveryClient.findById(id);
    }

    /**
     * 用户收货地址分页
     *
     * @param wxCode
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findByWxCode(String wxCode, Integer pageNo, Integer pageSize) {
        return deliveryClient.findByWxCode(wxCode,pageNo,pageSize);
    }

    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> add(Delivery delivery) {
        return deliveryClient.add(delivery);
    }


    /**
     * 修改收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> update(Delivery delivery) {
        return deliveryClient.update(delivery);
    }


    /**
     * 删除收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> delete(Delivery delivery) {
        return deliveryClient.delete(delivery);
    }


    /**
     * 设置默认地址
     *
     * @param id
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<String> defaultAddress(Long id, String wxCode) {
        return deliveryClient.defaultAddress(id,wxCode);
    }


    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<Delivery> getDefault(String wxCode) {
        return deliveryClient.getDefault(wxCode);
    }


}
