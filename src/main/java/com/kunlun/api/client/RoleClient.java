package com.kunlun.api.client;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.RoleClientHystrix;
import com.kunlun.entity.SysRole;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-29.
 */

@FeignClient(value = "cloud-service-common",fallback = RoleClientHystrix.class)
public interface RoleClient {


    /**
     * 新增角色
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/role/add")
     DataRet<String> addRole(@RequestBody SysRole sysRole);


    /**
     * 修改角色信息
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/role/update")
     DataRet<String> update(@RequestBody SysRole sysRole);


    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @PostMapping("/role/deleteById")
     DataRet<String> deleteById(@RequestParam(value = "id") Long id);


    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    @GetMapping("/role/findById")
     DataRet<SysRole> findById(@RequestParam(value = "id") Long id);


    /**
     * 列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @GetMapping("/role/findByCondition")
     PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                                      @RequestParam(value = "pageSize") Integer pageSize,
                                      @RequestParam(value = "searchKey",required = false) String searchKey);


    /**
     * 角色分配菜单
     *
     * @param object
     * @return
     */
    @PostMapping("/role/distribution/menu")
     DataRet<String> getMenu(@RequestBody JSONObject object);


    /**
     * 用户分配角色
     *
     * @param roleId
     * @param userId
     * @return
     */
    @PostMapping("/role/distribution/user")
     DataRet<String>getUser(@RequestParam(value = "roleId") Long roleId,
                                  @RequestParam(value = "userId") Long userId);
}
