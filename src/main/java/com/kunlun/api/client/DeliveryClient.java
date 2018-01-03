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
     * @param id
     * @return
     */
    @GetMapping("/delivery/findDetailById")
    DataRet<Delivery> findById(@RequestParam(value = "id") Long id);


    /**
     *用户收货地址分页
     *
     * @param wxCode
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/delivery/findByWxCode")
     PageResult findByWxCode(@RequestParam(value = "wxCode") String wxCode,
                                   @RequestParam(value = "pageNo") Integer pageNo,
                                   @RequestParam(value = "pageSize") Integer pageSize);



    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/add")
     DataRet<String> add(@RequestBody Delivery delivery);


    /**
     * 修改收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/update")
     DataRet<String> update(@RequestBody Delivery delivery);


    /**
     * 删除收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/delete")
     DataRet<String> delete(@RequestBody Delivery delivery);



    /**
     * 设置默认收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/defaultAddress")
     DataRet<String> defaultAddress(@RequestParam(value = "id") Long id,
                                    @RequestParam(value = "wxCode") String wxCode);




    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    @RequestMapping(value = "/getDefault", method = RequestMethod.GET)
     DataRet<Delivery> getDefault(@RequestParam(value = "wxCode") String wxCode);



}
