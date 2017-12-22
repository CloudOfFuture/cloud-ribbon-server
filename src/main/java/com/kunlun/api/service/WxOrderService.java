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
     * 退款
     *
     * @param orderId
     * @param wxCode
     * @return
     */
    @GetMapping("/wx/order/refund")
    DataRet<String> refund(@RequestParam(value = "order_id") Long orderId,
                           @RequestParam(value = "wx_code") String wxCode,
                           @RequestParam(value = "refund_fee", required = false) Integer refundFee);


    /**
     * 我的订单列表/   分类查询（订单状态/支付类型）
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @param orderStatus
     * @param payType
     * @return
     */
    @GetMapping("/wx/order/findByOpenid")
    PageResult findByOpenid(@RequestParam(value = "page_no") Integer pageNo,
                            @RequestParam(value = "page_size") Integer pageSize,
                            @RequestParam(value = "wx_code") String wxCode,
                            @RequestParam(value = "order_status", required = false) String orderStatus,
                            @RequestParam(value = "pay_type", required = false) String payType);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/wx/order/findById")
    DataRet<OrderExt> findById(@RequestParam(value = "order_id") Long orderId);
}
