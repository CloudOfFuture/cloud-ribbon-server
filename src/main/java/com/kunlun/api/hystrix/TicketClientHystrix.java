package com.kunlun.api.hystrix;

import com.kunlun.api.client.TicketClient;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-04.
 */
@Component
public class TicketClientHystrix implements TicketClient {

    /**
     * 新增优惠券
     *
     * @param ticket
     * @return
     */
    @Override
    public DataRet add(Ticket ticket) {
        return new DataRet("ERROR", "新增优惠券失败");
    }

    /**
     * 模糊查询优惠券（带分页）
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return new PageResult("ERROR","查询失败");
    }
}
