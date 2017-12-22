package com.kunlun.api.hystrix;

import com.kunlun.api.service.WxOrderService;
import com.kunlun.entity.OrderExt;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * 微信订单接口  断路器
 *
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@Component
public class WxOrderServiceHystrix implements WxOrderService {

    /**
     * 退款
     *
     * @param orderId
     * @param wxCode
     * @param refundFee
     * @return
     */
    @Override
    public DataRet<String> refund(Long orderId, String wxCode, Integer refundFee) {
        return new DataRet<>("ERROR", "退款故障");
    }

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
    @Override
    public PageResult findByOpenid(Integer pageNo, Integer pageSize, String wxCode, String orderStatus, String payType) {
        return new PageResult("ERROR", "订单列表故障");
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<OrderExt> findById(Long orderId) {
        return new DataRet<>("ERROR", "查询订单详情故障");
    }
}
