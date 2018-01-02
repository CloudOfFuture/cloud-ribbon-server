package com.kunlun.api.hystrix;

import com.kunlun.api.client.MenuClient;
import com.kunlun.entity.SysMenu;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-28下午5:02
 * @desc
 */
@Component
public class MenuServiceHystrix implements MenuClient {
    @Override
    public DataRet findRootMenu() {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public DataRet findAllMenu() {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public DataRet findByUserId(Long userId) {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public DataRet findByRoleId(Long roleId) {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return new PageResult();
    }

    @Override
    public DataRet add(SysMenu sysMenu) {
        return new DataRet("ERROR", "添加失败");
    }

    @Override
    public DataRet update(SysMenu sysMenu) {
        return new DataRet("ERROR", "修改失败");
    }

    @Override
    public DataRet findById(Long id) {
        return new DataRet("ERROR", "查询失败");
    }

    @Override
    public DataRet deleteById(Long id) {
        return new DataRet("ERROR", "删除失败");
    }
}
