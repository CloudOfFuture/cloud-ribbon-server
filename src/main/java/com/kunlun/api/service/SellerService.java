package com.kunlun.api.service;

import com.kunlun.entity.Store;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-26.
 */
public interface SellerService {


    /**
     * 店铺创建
     *
     * @param store
     * @return
     */
    DataRet<String> add(Store store);

    /**
     * 修改店铺状态
     *
     * @param id
     * @param status 店铺状态 NORMAL 正常 ,
     *               CLOSE_LEADER 管理员关闭,
     *               CLOSE 关闭，
     *               DELETE 删除状态
     *@param operator
     * @return
     */
    DataRet<String> updateStatus(Long id, String status, Long operator);


    /**
     * 修改店铺信息
     *
     * @param store
     * @return
     */
    DataRet<String> update(Store store);

    /**
     * 查询店铺详情
     *
     * @param userId
     * @return
     */
    DataRet<Store> findByUserId(Long userId);

    /**
     * 店铺列表
     *
     * @param pageNo
     * @param pageSize
     * @param audit    审核状态 AUDITING待审核  NOT_PASS_AUDIT审核未通过 PASS_AUDIT审核通过
     * @return
     */
    PageResult findPage(Long userId, Integer pageNo, Integer pageSize, String audit, String searchKey);


    /**
     * 店铺审核
     *
     * @param audit  AUDITING 待审核/审核中    NOT_PASS_AUDIT 审核未通过  PASS_AUDIT 审核通过
     * @param reason
     * @param id
     * @return
     */
    DataRet<String> audit(String audit, String reason, Long id);
}
