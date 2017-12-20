package com.kunlun.api.controller;

import com.kunlun.api.service.WxOrderService;
import com.kunlun.entity.OrderExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 退款
     *
     * @return
     */
    @PostMapping("/refund")
    public DataRet<String> refund() {
        return null;
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/findById")
    public DataRet<OrderExt> findById(@RequestParam(value = "orderId") Long orderId) {
        return null;
    }

    @PostMapping("/estimate")
    public DataRet<String> estimate() {
        return null;
    }

    /**
     * 确认收货
     *
     * @return
     */
    @PostMapping("/confirmReceive")
    public DataRet<String> confirmReceive() {
        return null;
    }

}
