package com.kunlun.api.controller;

import com.kunlun.api.service.IndexService;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/index")
    public DataRet<String> index() {
        return indexService.index();
    }

}
