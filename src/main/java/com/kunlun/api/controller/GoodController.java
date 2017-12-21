package com.kunlun.api.controller;

import com.kunlun.api.service.GoodService;
import com.kunlun.entity.Good;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-21.
 */
@RestController
@RequestMapping("good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("/add")
    public DataRet<String> add(@RequestBody Good good){
        return goodService.add(good);
    }
}
