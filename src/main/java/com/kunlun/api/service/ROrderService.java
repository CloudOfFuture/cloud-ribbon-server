package com.kunlun.api.service;

import com.kunlun.api.hystrix.ROrderServiceHystrix;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@FeignClient(value = "cloud-service-order", fallback = ROrderServiceHystrix.class)
public interface ROrderService {

    /**
     * @param orderNo   订单编号
     * @param phone     收货人手机号
     * @param status    订单状态
     * @param type      订单类型
     * @param searchKey 搜索关键字
     * @param pageNo    当前页
     * @param pageSize  每页条数
     * @return
     */
    @GetMapping("/base/order/list")
    PageResult list(@RequestParam(value = "order_no") String orderNo,
                    @RequestParam(value = "phone") String phone,
                    @RequestParam(value = "status") String status,
                    @RequestParam(value = "type") String type,
                    @RequestParam(value = "search_key") String searchKey,
                    @RequestParam(value = "page_no") Integer pageNo,
                    @RequestParam(value = "page_size") Integer pageSize);

}
