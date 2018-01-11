package com.kunlun.api.client;

import com.kunlun.api.hystrix.DeliveryClientHystrix;
import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
@FeignClient(value = "cloud-service-user-center", fallback = DeliveryClientHystrix.class)
public interface DeliveryClient {

    /**
     * 根据id查找收获地址详情
     *
     * @param id
     * @return
     */
    @GetMapping("/delivery/findById")
    DataRet<Delivery> findById(@RequestParam(value = "id") Long id);


    /**
     * 用户收货地址分页
     *
     * @param wxCode
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/delivery/findByUserId")
    PageResult findByUserId(@RequestParam(value = "wxCode", required = false) String wxCode,
                            @RequestParam(value = "userId", required = false) Long userId,
                            @RequestParam(value = "pageNo") Integer pageNo,
                            @RequestParam(value = "pageSize") Integer pageSize);


    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/delivery/add")
    DataRet<String> add(@RequestBody Delivery delivery);


    /**
     * 修改收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/delivery/update")
    DataRet<String> update(@RequestBody Delivery delivery);


    /**
     * 删除收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/delivery/deleteById")
    DataRet<String> deleteById(@RequestParam(value = "id") Long id);


    /**
     * 设置默认收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/delivery/defaultAddress")
    DataRet<String> defaultAddress(@RequestParam(value = "id") Long id,
                                   @RequestParam(value = "wxCode", required = false) String wxCode,
                                   @RequestParam(value = "userId", required = false) Long userId);


    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    @RequestMapping(value = "/delivery/getDefault", method = RequestMethod.GET)
    DataRet<Delivery> getDefault(@RequestParam(value = "wxCode", required = false) String wxCode,
                                 @RequestParam(value = "userId", required = false) Long userId);


}
