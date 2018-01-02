package com.kunlun.api.service.impl;

import com.kunlun.api.client.MenuClient;
import com.kunlun.api.service.MenuService;
import com.kunlun.entity.SysMenu;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-28下午5:01
 * @desc
 */
@Service
public class MenuSeriveImpl implements MenuService {
    @Autowired
    MenuClient menuClient;

    @Override
    public DataRet add(SysMenu sysMenu) {
        return menuClient.add(sysMenu);
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        if (pageNo == null || pageSize == null) {
            return new PageResult();
        }
        return menuClient.findByCondition(pageNo, pageSize, searchKey);
    }

    @Override
    public DataRet update(SysMenu sysMenu) {
        if (sysMenu.getId() == null) {
            return new DataRet("ERROR", "参数错误，id不能为空");
        }
        return menuClient.update(sysMenu);
    }

    @Override
    public DataRet findById(Long id) {
        if (id == null) {
            return new DataRet("ERROR", "参数错误，id不能为空");
        }
        return menuClient.findById(id);
    }

    @Override
    public DataRet deleteById(Long id) {
        if (id == null) {
            return new DataRet("ERROR", "参数错误，id不能为空");
        }
        return menuClient.deleteById(id);
    }

    @Override
    public DataRet findByUserId(Long userId) {
        if (userId == null) {
            return new DataRet("ERROR", "参数错误，userId不能为空");
        }
        return menuClient.findByUserId(userId);
    }

    @Override
    public DataRet findRootMenu() {
        return menuClient.findRootMenu();
    }

    @Override
    public DataRet findByRoleId(Long roleId) {
        if (roleId == null) {
            return new DataRet("ERROR", "参数错误，roleId不能为空");
        }
        return menuClient.findByRoleId(roleId);
    }

    @Override
    public DataRet findAllMenu() {
        return menuClient.findAllMenu();
    }
}
