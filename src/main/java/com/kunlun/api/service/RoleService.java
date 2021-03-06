package com.kunlun.api.service;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.entity.SysRole;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;


/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-29.
 */
public interface RoleService {

    /**
     * 新增角色
     *
     * @param sysRole
     * @return
     */
    DataRet<String> add(SysRole sysRole);


    /**
     * 修改角色信息
     *
     * @param sysRole
     * @return
     */
    DataRet<String> update(SysRole sysRole);


    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    DataRet<String> deleteById(Long id);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    DataRet<SysRole> findById(Long id);


    /**
     * 列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey);


    /**
     * 角色分配菜单
     *
     * @param object
     * @return
     */
    DataRet<String> getMenu(JSONObject object);


    /**
     * 用户分配角色
     *
     * @param roleId
     * @param userId
     * @return
     */
    DataRet<String> getUser(Long roleId, Long userId);
}
