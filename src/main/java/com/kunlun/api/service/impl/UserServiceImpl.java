package com.kunlun.api.service.impl;

import com.kunlun.api.client.UserClient;
import com.kunlun.api.service.UserService;
import com.kunlun.entity.User;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-27 02:53
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserClient userClient;

    @Override
    public DataRet login(String mobile, String password, String ip) {
        return userClient.login(mobile, password, ip);
    }

    @Override
    public DataRet register(User user) {
        return userClient.register(user);
    }

    @Override
    public DataRet updateUserInfo(User user) {
        return userClient.updateUserInfo(user);
    }

    @Override
    public DataRet updateUserAuthInfo(User user) {
        return userClient.updateUserAuthInfo(user);
    }

    @Override
    public DataRet logout(String mobile) {
        return userClient.logout(mobile);
    }

    @Override
    public DataRet updatePassword(Long userId, String password) {
        return userClient.updatePassword(userId, password);
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String startDate, String endDate, String searchKey, String userType, String certification) {
        return userClient.findByCondition(pageNo, pageSize, startDate, endDate, searchKey, userType, certification);
    }

    @Override
    public DataRet findById(Long id) {
        return userClient.findById(id);
    }

    @Override
    public DataRet auditSeller(Long sellerId, Long operateId, String certification, String reason) {
        return userClient.auditSeller(sellerId, operateId, certification, reason);
    }
}
