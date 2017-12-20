package com.kunlun.api.controller;

import com.kunlun.api.service.WxOrderService;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信订单接口
 *
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@RestController
@RequestMapping("/api/wx/order")
public class WxOrderController {

    @Autowired
    private WxOrderService wxOrderService;

    /**
     * 订单列表
     *
     * @param orderCondition
     * @return
     */
    @GetMapping("/findByCondition")
    public PageResult findByCondition(@RequestBody OrderCondition orderCondition) {
        return wxOrderService.findByCondition(orderCondition);
    }


}
