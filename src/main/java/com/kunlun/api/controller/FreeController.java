package com.kunlun.api.controller;

import com.kunlun.api.service.FreeService;
import com.kunlun.result.DataRet;
import com.kunlun.utils.IpUtil;
import com.kunlun.wxentity.UnifiedRequestData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-09.
 */
@RestController
@RequestMapping("/free")
public class FreeController {

    @Autowired
    private FreeService freeService;

    /**
     * 试用预付款订单
     *
     * @param unifiedRequestData
     * @param request
     * @return
     */
    @PostMapping("/apply")
    public DataRet apply(@RequestBody UnifiedRequestData unifiedRequestData, HttpServletRequest request){
        String ipAddress= IpUtil.getIPAddress(request);
        unifiedRequestData.setIpAddress(ipAddress);
        return freeService.apply(unifiedRequestData);
    }
}
