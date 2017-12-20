package com.kunlun.api.controller;

import com.kunlun.api.service.ROrderService;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    private ROrderService rOrderService;

    @GetMapping("/list")
    public PageResult list(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return rOrderService.list(pageNo, pageSize);
    }
}
