package com.kunlun.api.hystrix;

import com.kunlun.api.client.UserClient;
import com.kunlun.entity.User;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-27 02:52
 */
@Component
public class UserClientHystrix implements UserClient {
    @Override
    public DataRet login(String mobile, String password,String ip) {
        return new DataRet("ERROR", "登录失败");
    }

    @Override
    public DataRet register(User user) {
        return new DataRet("ERROR", "注册失败");
    }

    @Override
    public DataRet updateUserInfo(User user) {
        return new DataRet("ERROR", "修改失败");
    }

    @Override
    public DataRet updateUserAuthInfo(User user) {
        return new DataRet("ERROR", "修改失败");
    }

    @Override
    public DataRet logout(String mobile) {
        return new DataRet("ERROR", "退出登录失败");
    }

    @Override
    public DataRet updatePassword(Long userId, String password) {
        return new DataRet("ERROR", "修改失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String startDate, String endDate, String searchKey, String userType, String certification) {
        return new PageResult();
    }

    @Override
    public DataRet findById(Long id) {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public DataRet auditSeller(Long sellerId, Long operateId, String certification, String reason) {
        return new DataRet("ERROR", "审核失败");
    }
}
