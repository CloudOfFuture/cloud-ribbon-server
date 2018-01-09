package com.kunlun.api.client;

import com.kunlun.api.hystrix.WxOrderClientHystrix;
import com.kunlun.entity.Order;
import com.kunlun.entity.OrderExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@FeignClient(value = "cloud-service-order")
public interface WxOrderClient {

    /**
     * 退款
     *
     * @param orderId
     * @return
     */
    @GetMapping("/wx/order/refund")
    DataRet<String> refund(@RequestParam(value = "orderId") Long orderId);


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
    PageResult findByOpenid(@RequestParam(value = "pageIo") Integer pageNo,
                            @RequestParam(value = "pageSize") Integer pageSize,
                            @RequestParam(value = "wxCode") String wxCode,
                            @RequestParam(value = "orderStatus", required = false) String orderStatus,
                            @RequestParam(value = "payType", required = false) String payType);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/wx/order/findById")
    DataRet<OrderExt> findById(@RequestParam(value = "orderId") Long orderId);
}
