package com.kunlun.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.RoleClient;
import com.kunlun.api.service.RoleService;
import com.kunlun.entity.SysRole;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-29.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleClient roleClient;


    /**
     * 新增角色
     *
     * @param sysRole
     * @return
     */
    @Override
    public DataRet<String> add(SysRole sysRole) {
        return roleClient.addRole(sysRole);
    }


    /**
     *修改角色信息
     *
     * @param sysRole
     * @return
     */
    @Override
    public DataRet<String> update(SysRole sysRole) {
        return roleClient.update(sysRole);
    }

    /**
     *删除角色
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return roleClient.deleteById(id);
    }

    /**
     *获取详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<SysRole> findById(Long id) {
        return roleClient.findById(id);
    }

    /**
     *列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return roleClient.findByCondition(pageNo,pageSize,searchKey);
    }



    /**
     *角色分配菜单
     *
     * @param object
     * @return
     */
    @Override
    public DataRet<String> getMenu(JSONObject object) {
        return roleClient.getMenu(object);
    }

    /**
     *用户分配角色
     *
     * @param roleId
     * @param userId
     * @return
     */
    @Override
    public DataRet<String> getUser(Long roleId, Long userId) {
        return roleClient.getUser(roleId,userId);
    }
}
