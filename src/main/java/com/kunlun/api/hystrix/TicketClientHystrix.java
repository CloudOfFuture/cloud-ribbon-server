package com.kunlun.api.hystrix;

import com.kunlun.api.client.TicketClient;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
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
}
