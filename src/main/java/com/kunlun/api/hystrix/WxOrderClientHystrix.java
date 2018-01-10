package com.kunlun.api.hystrix;

import com.kunlun.api.client.WxOrderClient;
import com.kunlun.entity.Order;
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
public class WxOrderClientHystrix implements WxOrderClient {

    /**
     * 退款
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<String> applyRefund(Long orderId) {
        return new DataRet<>("ERROR", "退款接口异常");
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
        return new PageResult("ERROR", "订单列表接口异常");
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<Order> findById(Long orderId) {
        return new DataRet<>("ERROR", "订单详情接口异常");
    }

    @Override
    public DataRet<String> confirmByGood(Long orderId, String ipAddress) {
        return new DataRet<>("ERROR", "接口异常");
    }

    @Override
    public DataRet<String> cancelByOrder(Long orderId, String ipAddress) {
        return new DataRet<>("ERROR", "接口异常");
    }
}
