package com.kunlun.api.hystrix;

import com.kunlun.api.client.DeliveryClient;
import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
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
     * 用户收货地址分页
     *
     * @param wxCode
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findByWxCode(String wxCode, Integer pageNo, Integer pageSize) {
        return new PageResult("ERROR","获取列表失败");
    }


    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> add(Delivery delivery) {
        return new DataRet<>("ERROR","新增失败");
    }


    /**
     * 修改收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> update(Delivery delivery) {
        return new DataRet<>("ERROR","修改失败");
    }


    /**
     * 删除收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> delete(Delivery delivery) {
        return new DataRet<>("ERROR","删除收货地址失败");
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
        return new DataRet<>("ERROR","设置默认地址失败");
    }


    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<Delivery> getDefault(String wxCode) {
        return new DataRet<>("ERROR","获取默认地址失败");
    }

}
