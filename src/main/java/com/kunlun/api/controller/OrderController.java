package com.kunlun.api.controller;

import com.kunlun.api.service.OrderService;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    /**
     * 订单列表
     *
     * @param orderNo   订单编号
     * @param phone     收货人手机号
     * @param status    订单状态
     * @param orderType 订单类型
     * @param searchKey 搜索关键字
     * @param pageNo    当前页
     * @param pageSize  每页条数
     * @return
     */
    @GetMapping("/findByCondition")
    public PageResult list(@RequestParam(value = "orderNo", required = false) String orderNo,
                           @RequestParam(value = "phone", required = false) String phone,
                           @RequestParam(value = "status", required = false) String status,
                           @RequestParam(value = "type", required = false) String orderType,
                           @RequestParam(value = "searchKey", required = false) String searchKey,
                           @RequestParam(value = "pageNo") Integer pageNo,
                           @RequestParam(value = "pageSize") Integer pageSize) {
        return orderService.list(orderNo, phone, status, orderType, searchKey, pageNo, pageSize);
    }

    /**
     * 发货
     * orderId
     * deliveryNo
     * expressName
     * expressNo
     * senderId
     *
     * @param orderCondition
     * @return
     */
    @PostMapping("/sendGood")
    public DataRet<String> sendGood(@RequestBody OrderCondition orderCondition) {
        return orderService.sendGood(orderCondition);
    }

    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    @PostMapping("/modify")
    public DataRet<String> modify(@RequestBody Order order) {
        return orderService.modify(order);
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/findById")
    public DataRet<Order> findById(@RequestParam Long orderId, @RequestHeader Long sellerId) {
        return orderService.findById(orderId, sellerId);
    }

    /**
     * 退款
     *
     * @param orderId   Long
     * @param flag      AGREE 同意  REFUSE  拒绝
     * @param remark    String
     * @param refundFee Integer
     * @return DataRet
     */
    @PostMapping("/audit/refund")
    public DataRet<String> auditRefund(@RequestParam("orderId") Long orderId,
                                       @RequestParam("flag") String flag,
                                       @RequestParam(value = "remark", required = false) String remark,
                                       @RequestParam(value = "refundFee") Integer refundFee) {
        return orderService.auditRefund(orderId, flag, remark, refundFee);
    }
}
