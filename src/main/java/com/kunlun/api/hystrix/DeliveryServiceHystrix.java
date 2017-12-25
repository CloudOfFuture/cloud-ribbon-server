package com.kunlun.api.hystrix;

import com.kunlun.api.service.DeliveryService;
import com.kunlun.result.DataRet;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
public class DeliveryServiceHystrix implements DeliveryService{


    /**
     * 根据id查找收获地址详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet findById(Long id) {
        return new DataRet("Error","收获地址无效");
    }
}
