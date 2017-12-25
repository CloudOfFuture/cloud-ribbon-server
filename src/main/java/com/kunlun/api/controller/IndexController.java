package com.kunlun.api.controller;

import com.kunlun.api.service.IndexService;
import com.kunlun.api.service.OrderService;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;


    @GetMapping("/log")
    public void log(@RequestParam("orderNo") String orderNo){
        indexService.index(orderNo);
    }

}
