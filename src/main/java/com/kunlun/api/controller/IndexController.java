package com.kunlun.api.controller;

import com.kunlun.api.service.IndexService;
import com.kunlun.api.service.OrderService;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
@RestController
@RequestMapping("/ribbon")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/test")
    public DataRet<String> test(@RequestParam(value = "order_id") Long orderId) {
        return orderService.test(orderId);
    }

    /**
     * 测试服务接口之间调用
     *
     * @param orderId
     * @return
     */
    @GetMapping("/log")
    public DataRet<String> logTest(@RequestParam(value = "order_id") Long orderId) {
        return indexService.logTest(orderId);
    }
}
