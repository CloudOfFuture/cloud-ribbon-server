package com.kunlun.api.service.impl;

import com.github.pagehelper.util.StringUtil;
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
        if (id == null) {
            return new DataRet<>("ERROR", "参数错误");
        }
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
    public PageResult findByUserId(String wxCode, Long userId, Integer pageNo, Integer pageSize) {
        if (StringUtil.isEmpty(wxCode) && userId == null) {
            return new PageResult("ERROR", "参数错误");
        }
        if (pageSize == null || pageNo == null) {
            return new PageResult("ERROR", "参数错误");
        }
        return deliveryClient.findByUserId(wxCode, userId, pageNo, pageSize);
    }

    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    @Override
    public DataRet<String> add(Delivery delivery) {
        if (StringUtil.isEmpty(delivery.getWxCode()) && StringUtil.isEmpty(delivery.getUserId())) {
            return new DataRet<>("ERROR", "参数错误");
        }
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
        if (delivery.getId() == null) {
            return new DataRet<>("ERROR", "参数错误");
        }
        return deliveryClient.update(delivery);
    }


    /**
     * 删除收货地址
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        if (id == null) {
            return new DataRet<>("ERROR", "参数错误");
        }
        return deliveryClient.deleteById(id);
    }


    /**
     * 设置默认地址
     *
     * @param id
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<String> defaultAddress(Long id, String wxCode, Long userId) {
        if (id == null) {
            return new DataRet<>("ERROR", "参数错误");
        }
        if (StringUtil.isEmpty(wxCode) && userId == null) {
            return new DataRet<>("ERROR", "参数错误");
        }
        return deliveryClient.defaultAddress(id, wxCode, userId);
    }


    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    @Override
    public DataRet<Delivery> getDefault(String wxCode, Long userId) {
        if (StringUtil.isEmpty(wxCode) && userId == null) {
            return new DataRet<>("ERROR", "参数错误");
        }
        return deliveryClient.getDefault(wxCode, userId);
    }


}
