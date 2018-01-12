package com.kunlun.api.client;

import com.kunlun.api.hystrix.WxOrderClientHystrix;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/26.
 */
@FeignClient(value = "cloud-service-order", fallback = WxOrderClientHystrix.class)
public interface WxOrderClient {

    /**
     * 退款
     *
     * @param orderId
     * @return
     */
    @GetMapping("/wx/order/applyRefund")
    DataRet<String> applyRefund(@RequestParam(value = "orderId") Long orderId);


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
    DataRet<Order> findById(@RequestParam(value = "orderId") Long orderId);

    /**
     * 确认收货
     *
     * @param orderId   订单id
     * @param ipAddress 请求ip
     * @return
     */
    @PostMapping("/wx/order/confirmByGood")
    DataRet<String> confirmByGood(@RequestParam("orderId") Long orderId,
                                  @RequestParam(value = "ipAddress", required = false) String ipAddress);

    /**
     * 取消订单
     *
     * @param orderId   订单id
     * @param ipAddress 请求ip
     * @return
     */
    @PostMapping("/wx/order/cancelByOrder")
    DataRet<String> cancelByOrder(@RequestParam("orderId") Long orderId,
                                  @RequestParam(value = "ipAddress", required = false) String ipAddress);

    /**
     * 新增订单
     *
     * @param order 订单
     * @return
     */
    @PostMapping("/wx/order/addOrder")
    DataRet<String> addOrder(@RequestBody Order order);

    /**
     * 修改订单预付款订单号
     *
     * @param id
     * @param prepayId
     * @return
     */
    @PostMapping("/wx/order/updatePrepayId")
    DataRet<String> updateOrderPrepayId(@RequestParam("id") Long id,
                                        @RequestParam("prepayId") String prepayId);

    /**
     * 查询退款中的订单列表
     *
     * @param orderStatus
     * @return
     */
    @GetMapping("/wx/order/findRefundingOrder")
    DataRet<List<Order>> findRefundingOrder(@RequestParam("orderStatus") String orderStatus);

    /**
     * 查询未付款订单列表
     *
     * @param orderStatus
     * @return
     */
    @GetMapping("/wx/order/findUnPayOrder")
    DataRet<List<Order>> findUnPayOrder(@RequestParam("orderStatus") String orderStatus);
}
