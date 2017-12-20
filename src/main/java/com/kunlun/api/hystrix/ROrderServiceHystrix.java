package com.kunlun.api.hystrix;

import com.kunlun.api.service.ROrderService;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/20.
 */
@Component
public class ROrderServiceHystrix implements ROrderService {
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {
        return new PageResult("ERROR","获取订单列表异常");
    }
}
