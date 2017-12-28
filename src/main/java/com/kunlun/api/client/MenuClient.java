package com.kunlun.api.client;

import com.kunlun.api.hystrix.MenuServiceHystrix;
import com.kunlun.entity.SysMenu;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-28下午5:02
 * @desc
 */
@FeignClient(value = "cloud-service-common", fallback = MenuServiceHystrix.class)
public interface MenuClient {
    /**
     * 查询菜单根菜单列表
     *
     * @return DataRet
     */
    @GetMapping(value = "/sys/menu/findRootMenu")
    DataRet findRootMenu();


    /**
     * 分层级查询菜单列表
     *
     * @return DataRet
     */
    @GetMapping(value = "/sys/menu/findAllMenu")
    DataRet findAllMenu();

    /**
     * 用户菜单列表
     *
     * @param userId Long
     * @return DataRet
     */
    @GetMapping(value = "/sys/menu/findByUserId")
    DataRet findByUserId(@RequestParam(value = "userId") Long userId);

    /**
     * 根据角色id查询菜单列表
     *
     * @param roleId Long
     * @return DataRet
     */
    @GetMapping(value = "/sys/menu/findByRoleId")
    DataRet findByRoleId(@RequestParam(value = "roleId") Long roleId);

    /**
     * 菜单列表
     *
     * @param pageNo    Integer
     * @param pageSize  Integer
     * @param searchKey String
     * @return PageResult
     */
    @GetMapping(value = "/sys/menu/findByCondition")
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "searchKey", required = false) String searchKey);

    /**
     * 菜单添加
     *
     * @param sysMenu SysMenu
     * @return DataRet
     */
    @PostMapping(value = "/sys/menu/add")
    DataRet add(@RequestBody SysMenu sysMenu);

    /**
     * 菜单修改
     *
     * @param sysMenu SysMenu
     * @return DataRet
     */
    @PostMapping(value = "/sys/menu/update")
    DataRet update(@RequestBody SysMenu sysMenu);

    /**
     * 菜单详情
     *
     * @param id Long
     * @return DataRet
     */
    @GetMapping(value = "/sys/menu/findById")
    DataRet findById(@RequestParam(value = "id") Long id);

    /**
     * 菜单删除
     *
     * @param id Long
     * @return DataRet
     */
    @PostMapping(value = "/sys/menu/deleteById")
    DataRet deleteById(@RequestParam(value = "id") Long id);

}
