package com.kunlun.api.controller;

import com.kunlun.api.service.GroupService;
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
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-12.
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    /**
     * 参见拼团
     *
     * @param unifiedRequestData
     * @param request
     * @return
     */
    @PostMapping(value = "/joinGroup")
    public DataRet joinGroup(@RequestBody UnifiedRequestData unifiedRequestData, HttpServletRequest request) {
        String ipAddress = IpUtil.getIPAddress(request);
        unifiedRequestData.setIpAddress(ipAddress);
        return groupService.joinGroup(unifiedRequestData);
    }

}

