package com.kunlun.api.client;

import com.kunlun.api.hystrix.UserClientHystrix;
import com.kunlun.entity.User;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-27 02:52
 */
@FeignClient(value = "cloud-service-user-center", fallback = UserClientHystrix.class)
public interface UserClient {
    /**
     * 后台登录
     *
     * @param mobile   手机号
     * @param password 密码
     * @param ip       请求ip
     * @return DataRet
     */
    @PostMapping("/user/login")
    DataRet login(@RequestParam(value = "mobile") String mobile,
                  @RequestParam(value = "password") String password,
                  @RequestParam(value = "ip") String ip);

    /**
     * 管理后台注册
     *
     * @param user    User
     * @return DataRet
     */
    @PostMapping("/user/register")
    DataRet register(@RequestBody User user);

    /**
     * 修改个人资料
     *
     * @param user User
     * @return DataRet
     */
    @PostMapping("/user/updateInfo")
    DataRet updateUserInfo(@RequestBody User user);

    /**
     * 修改个人资料
     *
     * @param user User
     * @return DataRet
     */
    @PostMapping("/user/updateAuthInfo")
    DataRet updateUserAuthInfo(@RequestBody User user);

    /**
     * 后台系统退出登录
     *
     * @param mobile 手机号
     * @return DataRet
     */
    @PostMapping("/user/logout")
    DataRet logout(@RequestParam(value = "mobile") String mobile);

    /**
     * 修改密码
     *
     * @param userId   Long
     * @param password String
     * @return DataRet
     */
    @PostMapping("/user/updatePassword")
    DataRet updatePassword(@RequestParam(value = "userId") Long userId,
                           @RequestParam(value = "password") String password);

    /**
     * 分页条件查询 会员列表
     *
     * @param pageNo        当前页
     * @param pageSize      每页条数
     * @param startDate     注册时间
     * @param endDate       注册时间
     * @param searchKey     模糊查询信息
     * @param userType      用户类型
     * @param certification 认证
     * @return List
     */
    @GetMapping("/user/findByCondition")
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "startDate", required = false) String startDate,
                               @RequestParam(value = "endDate", required = false) String endDate,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "userType", required = false) String userType,
                               @RequestParam(value = "certification", required = false) String certification);

    /**
     * 根据id查询详情
     *
     * @param id Long
     * @return DataRet
     */
    @GetMapping("/user/findById")
    DataRet findById(@RequestParam(value = "id") Long id);

    /**
     * 审核商户信息
     *
     * @param sellerId      商户id
     * @param operateId     操作人id
     * @param certification 认证标识
     *                      NOT_AUTH 未实名认证,
     *                      AUTH_ING 审核中，
     *                      PASS_AUTH 认证通过，
     *                      NOT_PASS_AUTH 认证未通过
     * @param reason        不通过原因
     * @return DataRet
     */
    @PostMapping("/user/auditSeller")
    DataRet auditSeller(@RequestParam(value = "sellerId") Long sellerId,
                        @RequestParam(value = "operateId") Long operateId,
                        @RequestParam(value = "certification") String certification,
                        @RequestParam(value = "reason", required = false) String reason);

}
