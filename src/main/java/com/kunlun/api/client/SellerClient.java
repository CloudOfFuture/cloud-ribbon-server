package com.kunlun.api.client;


import com.kunlun.api.hystrix.SellerClientHystrix;
import com.kunlun.entity.Store;
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
 * @created on 2017-12-26.
 */
@FeignClient(value = "cloud-service-seller",fallback = SellerClientHystrix.class)
public interface SellerClient {

    /**
     * 店铺创建
     *
     * @param store
     * @return
     */
    @PostMapping("/seller/add/store")
    DataRet<String> add(@RequestBody Store store);

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
    @PostMapping("/seller/updateStatus")
    DataRet<String> updateStatus(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "status") String status,
                                 @RequestParam(value = "operator") String operator);


    /**
     * 修改店铺信息
     *
     * @param store
     * @return
     */
    @PostMapping("/seller/modify")
    DataRet<String> update(@RequestBody Store store);

    /**
     * 查询店铺详情
     *
     * @param userId
     * @return
     */
    @GetMapping("/seller/findByUserId")
    DataRet<Store> findByUserId(@RequestParam(value = "userId") Long userId);

    /**
     * 店铺列表
     *
     * @param pageNo
     * @param pageSize
     * @param audit    审核状态 AUDITING待审核  NOT_PASS_AUDIT审核未通过 PASS_AUDIT审核通过
     * @return
     */
    @GetMapping("/seller/findPage")
    PageResult findPage(@RequestParam(value = "userId",required = false) Long userId,
                        @RequestParam(value = "pageNo") Integer pageNo,
                        @RequestParam(value = "pageSize") Integer pageSize,
                        @RequestParam(value = "audit",required = false) String audit,
                        @RequestParam(value = "searchKey",required = false) String searchKey);


    /**
     * 店铺审核
     *
     * @param audit  AUDITING 待审核/审核中    NOT_PASS_AUDIT 审核未通过  PASS_AUDIT 审核通过
     * @param reason
     * @param id
     * @return
     */
    @PostMapping("/seller/audit")
    DataRet<String> audit(@RequestParam(value = "audit") String audit,
                          @RequestParam(value = "reason",required = false) String reason,
                          @RequestParam(value = "id") Long id);
}
