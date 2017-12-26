package com.kunlun.api.service.impl;

import com.kunlun.api.client.SellerClient;
import com.kunlun.api.service.SellerService;
import com.kunlun.entity.Store;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-26.
 */
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerClient sellerClient;

    @Override
    public DataRet<String> add(Store store) {
        return sellerClient.add(store);
    }


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
    @Override
    public DataRet<String> updateStatus(Long id, String status, String operator) {
        return sellerClient.updateStatus(id,status,operator);
    }

    /**
     * 修改店铺信息
     *
     * @param store
     * @return
     */
    @Override
    public DataRet<String> update(Store store) {
        return sellerClient.update(store);
    }

    /**
     * 查询店铺详情
     *
     * @param userId
     * @return
     */
    @Override
    public DataRet<Store> findByUserId(Long userId) {
        return sellerClient.findByUserId(userId);
    }


    /**
     * 店铺列表
     *
     * @param pageNo
     * @param pageSize
     * @param audit    审核状态 AUDITING待审核  NOT_PASS_AUDIT审核未通过 PASS_AUDIT审核通过
     * @return
     */
    @Override
    public PageResult findPage(Long userId, Integer pageNo, Integer pageSize, String audit, String searchKey) {
        return sellerClient.findPage(userId,pageNo,pageSize,audit,searchKey);
    }

    /**
     * 店铺审核
     *
     * @param audit  AUDITING 待审核/审核中    NOT_PASS_AUDIT 审核未通过  PASS_AUDIT 审核通过
     * @param reason
     * @param id
     * @return
     */
    @Override
    public DataRet<String> audit(String audit, String reason, Long id) {
        return sellerClient.audit(audit,reason,id);
    }
}
