package com.kunlun.api.controller;

import com.kunlun.api.service.PayService;
import com.kunlun.result.DataRet;
import com.kunlun.utils.IpUtil;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-12.
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;


    /**
     * 统一下单
     *
     * @param unifiedRequestData
     * @return
     */
    @PostMapping("/order/unifiedOrder")
    public DataRet<Object> unifiedOrder(@RequestBody UnifiedRequestData unifiedRequestData,
                                        HttpServletRequest request) {

        String ipAddress = IpUtil.getIPAddress(request);
        unifiedRequestData.setIpAddress(ipAddress);
        return payService.unifiedOrder(unifiedRequestData);
    }
}
