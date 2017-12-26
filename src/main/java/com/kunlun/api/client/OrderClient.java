package com.kunlun.api.client;

import com.kunlun.api.hystrix.OrderServiceHystrix;
import com.kunlun.entity.Order;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.OrderCondition;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */
@FeignClient(value = "cloud-service-order", fallback = OrderServiceHystrix.class)
public interface OrderClient {


    /**
     * 测试
     *
     * @param orderId
     * @return
     */
    @GetMapping("/index/log")
    DataRet<String> test(@RequestParam("orderId") Long orderId);

    /**
     * 订单列表
     *
     * @param orderNo   订单编号
     * @param phone     收货人手机号
     * @param status    订单状态
     * @param type      订单类型
     * @param searchKey 搜索关键字
     * @param pageNo    当前页
     * @param pageSize  每页条数
     * @return
     */
    @GetMapping("/backend/order/findByCondition")
    PageResult list(@RequestParam("orderNo") String orderNo,
                    @RequestParam("phone") String phone,
                    @RequestParam("status") String status,
                    @RequestParam("type") String type,
                    @RequestParam("searchKey") String searchKey,
                    @RequestParam("pageNo") Integer pageNo,
                    @RequestParam("pageSize") Integer pageSize);

    /**
     * 发货
     *
     * @param orderCondition
     * @return
     */
    @PostMapping("/backend/order/sendGood")
    DataRet<String> sendGood(@RequestBody OrderCondition orderCondition);


    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    @PostMapping("/backend/order/modify")
    DataRet<String> modify(@RequestBody Order order);


    /**
     * 查询订单详情
     *
     * @param orderId
     * @param sellerId
     * @return
     */
    @GetMapping("/findById")
    DataRet<Order> findById(@RequestParam("orderId") Long orderId, @RequestHeader("sellerId") Long sellerId);

}
