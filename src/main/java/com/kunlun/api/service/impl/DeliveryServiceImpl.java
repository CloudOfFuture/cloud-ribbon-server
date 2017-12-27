package com.kunlun.api.service.impl;

import com.kunlun.api.client.DeliveryClient;
import com.kunlun.api.service.DeliveryService;
import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
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


}
