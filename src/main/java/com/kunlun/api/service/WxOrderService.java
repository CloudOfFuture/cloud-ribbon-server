package com.kunlun.api.service;

import com.kunlun.api.hystrix.WxOrderServiceHystrix;
import com.kunlun.entity.OrderExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@FeignClient(value = "cloud-service-order", fallback = WxOrderServiceHystrix.class)
public interface WxOrderService {

    /**
     * 查询订单列表
     *
     * @param orderCondition
     * @return
     */
    @GetMapping("/service/wx/order/findByCondition")
    PageResult findByCondition(@RequestBody OrderCondition orderCondition);

    /**
     * 退款
     *
     * @param orderId
     * @param wxCode
     * @return
     */
    @PostMapping("/service/wx/order/refund")
    DataRet<String> refund(@RequestParam(value = "order_id") Long orderId, @RequestParam(value = "wx_code") String wxCode);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/service/wx/order/findById")
    DataRet<OrderExt> findById(@RequestParam(value = "order_id") Long orderId);

    /**
     * 确认收货
     *
     * @param orderId
     * @return
     */
    @PostMapping("/service/wx/order/confirmReceive")
    DataRet<String> confirmReceive(@RequestParam(value = "order_id") Long orderId);

}
