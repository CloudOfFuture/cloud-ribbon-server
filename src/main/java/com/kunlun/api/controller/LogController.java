package com.kunlun.api.controller;

import com.kunlun.api.service.LogService;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@RestController
@RequestMapping("log")
public class LogController {


    @Autowired
    private LogService logService;

    @PostMapping("/add/orderLog/")
    public DataRet<String> addOrderLog(@RequestBody OrderLog orderLog) {
        return logService.addOrderLog(orderLog);
    }


    /**
     * 创建商品日志
     *
     * @param goodName
     * @param action
     * @param goodId
     * @return
     */
    @PostMapping("/add/goodLog")
    public DataRet<String> saveGoodLog(@RequestParam(value = "goodName") String goodName,
                                       @RequestParam(value = "action") String action,
                                       @RequestParam(value = "goodId") Long goodId){
        return logService.addGoodLog(goodName,action,goodId);
    }
}
