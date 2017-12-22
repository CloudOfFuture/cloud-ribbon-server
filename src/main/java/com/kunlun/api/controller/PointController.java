package com.kunlun.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@RestController
@RequestMapping("point")
public class PointController {

    @GetMapping("/checkPoint")
    public String checkPoint(@RequestParam(value = "pointValue") Integer pointValue,
                             @RequestParam(value = "openid") String openid) {
        return null;
    }
}
