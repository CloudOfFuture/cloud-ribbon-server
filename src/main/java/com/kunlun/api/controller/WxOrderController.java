package com.kunlun.api.controller;

import com.kunlun.api.service.WxOrderService;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信订单接口
 *
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@RestController
@RequestMapping("wx/order")
public class WxOrderController {

    @Autowired
    private WxOrderService wxOrderService;

    /**
     * 我的订单列表/   分类查询（订单状态/支付类型）
     *
     * @param pageNo      当前页
     * @param pageSize    每条页数
     * @param wxCode      微信code
     * @param orderStatus 订单状态
     * @param payType     支付类型
     * @return
     */
    @GetMapping("/findByOpenid")
    public PageResult findByOpenid(@RequestParam(value = "pageNo") Integer pageNo,
                                   @RequestParam(value = "pageSize") Integer pageSize,
                                   @RequestParam(value = "wxCode") String wxCode,
                                   @RequestParam(value = "orderStatus", required = false) String orderStatus,
                                   @RequestParam(value = "payType", required = false) String payType) {
        return wxOrderService.findByOpenid(pageNo, pageSize, wxCode, orderStatus, payType);
    }

    /**
     * 退款
     *
     * @return
     */
    @GetMapping("/applyRefund")
    public DataRet<String> applyRefund(@RequestParam(value = "orderId") Long orderId) {
        return wxOrderService.applyRefund(orderId);
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/findById")
    public DataRet<Order> findById(@RequestParam(value = "orderId") Long orderId) {
        return wxOrderService.findById(orderId);
    }

    /**
     * 确认收货
     *
     * @param orderId 订单id
     * @param request 请求ip
     * @return
     */
    @PostMapping("/confirmByGood")
    public DataRet<String> confirmByGood(@RequestParam(value = "orderId") Long orderId,
                                         HttpServletRequest request) {
        String ipAddress = IpUtil.getIPAddress(request);
        return wxOrderService.confirmByGood(orderId, ipAddress);
    }

    /**
     * 取消订单
     *
     * @param orderId 订单id
     * @param request 请求ip
     * @return
     */
    @PostMapping("/cancelByOrder")
    public DataRet<String> cancelByOrder(@RequestParam(value = "orderId") Long orderId,
                                         HttpServletRequest request) {
        String ipAddress = IpUtil.getIPAddress(request);
        return wxOrderService.cancelByOrder(orderId, ipAddress);
    }
}
