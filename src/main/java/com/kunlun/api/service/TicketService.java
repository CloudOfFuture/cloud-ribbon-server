package com.kunlun.api.service;

import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-04.
 */
public interface TicketService {

    /**
     * 新增优惠券
     *
     * @param ticket
     * @return
     */
    DataRet add(Ticket ticket);
}
