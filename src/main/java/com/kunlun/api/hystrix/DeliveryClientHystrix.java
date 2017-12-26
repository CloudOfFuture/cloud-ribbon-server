package com.kunlun.api.hystrix;

import com.kunlun.api.client.DeliveryClient;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
@Component
public class DeliveryClientHystrix implements DeliveryClient{

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

    /**
     * 根据id校验收获地址
     *
     * @param id
     * @return
     */
    @Override
    public String check(Long id) {
        return "系统错误";
    }
}
