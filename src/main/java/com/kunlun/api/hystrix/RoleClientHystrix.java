package com.kunlun.api.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.client.RoleClient;
import com.kunlun.entity.SysRole;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-29.
 */
@Component
public class RoleClientHystrix implements RoleClient{


    /**
     * 新增失败回调
     *
     * @param sysRole
     * @return
     */
    @Override
    public DataRet<String> addRole(SysRole sysRole) {
        return new DataRet<>("ERROR","新增失败");
    }


    /**
     * 修改失败回调
     *
     * @param sysRole
     * @return
     */
    @Override
    public DataRet<String> update(SysRole sysRole) {
        return new DataRet<>("ERROR","修改失败");
    }


    /**
     * 删除失败回调
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<String> deleteById(Long id) {
        return new DataRet<>("ERROR","删除失败");
    }

    /**
     * 获取详情失败回调
     *
     * @param id
     * @return
     */
    @Override
    public DataRet<SysRole> findById(Long id) {
        return new DataRet<>("ERROR","获取详情失败");
    }

    /**
     * 分页失败回调
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return new PageResult("ERROR","分页失败");

    }

    /**
     * 分配失败回调
     *
     * @param object
     * @return
     */
    @Override
    public DataRet<String> getMenu(JSONObject object) {
        return new DataRet<>("ERROR","分配失败");

    }

    /**
     * 用户分配角色失败回调
     *
     * @param roleId
     * @param userId
     * @return
     */
    @Override
    public DataRet<String> getUser(Long roleId, Long userId) {
        return new DataRet<>("ERROR","用户分配角色失败");
    }
}
