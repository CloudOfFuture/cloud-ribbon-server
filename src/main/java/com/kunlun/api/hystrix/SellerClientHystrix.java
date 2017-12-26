package com.kunlun.api.hystrix;

import com.kunlun.api.client.SellerClient;
import com.kunlun.entity.Store;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-26.
 */
@Component
public class SellerClientHystrix implements SellerClient{

    /**
     * 创建商铺
     *
     * @param store
     * @return
     */
    @Override
    public DataRet<String> add(Store store) {
        return new DataRet<>("ERROR","商铺创建失败");
    }

    /**
     * 更新店铺状态
     *
     * @param id
     * @param status 店铺状态 NORMAL 正常 ,
     *               CLOSE_LEADER 管理员关闭,
     *               CLOSE 关闭，
     * @param operator
     * @return
     */
    @Override
    public DataRet<String> updateStatus(Long id, String status, String operator) {
        return new DataRet<>("ERROR","更新状态失败");
    }

    /**
     * 修改店铺信息
     *
     * @param store
     * @return
     */
    @Override
    public DataRet<String> update(Store store) {
        return new DataRet<>("ERROR","修改店铺信息失败");
    }

    /**
     * 获取详情
     *
     * @param userId
     * @return
     */
    @Override
    public DataRet<Store> findByUserId(Long userId) {
        return new DataRet<>("ERROR","获取详情失败");
    }

    /**
     * 分页
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param audit    审核状态 AUDITING待审核  NOT_PASS_AUDIT审核未通过 PASS_AUDIT审核通过
     * @param searchKey
     * @return
     */
    @Override
    public PageResult findPage(Long userId, Integer pageNo, Integer pageSize, String audit, String searchKey) {
        return new PageResult();
    }


    /**
     * 审核
     *
     * @param audit  AUDITING 待审核/审核中    NOT_PASS_AUDIT 审核未通过  PASS_AUDIT 审核通过
     * @param reason
     * @param id
     * @return
     */
    @Override
    public DataRet<String> audit(String audit, String reason, Long id) {
        return new DataRet<>("ERROR","审核失败");
    }
}
