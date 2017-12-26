package com.kunlun.api.controller;

import com.kunlun.api.service.DeliveryService;
import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
@RestController
@RequestMapping("delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    /**
     * 根据id查找收货地址
     *
     * @param id
     * @return
     */
    @GetMapping("findById")
    private DataRet<Delivery> findById(@RequestParam(value = "id") Long id) {
        return deliveryService.findById(id);
    }

    /**
     * 根据id校验收获地址
     *
     * @param id
     * @return
     */
    @GetMapping("check")
    private String check(@RequestParam(value = "id") Long id) {
        return deliveryService.check(id);
    }
}
