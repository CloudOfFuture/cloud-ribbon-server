package com.kunlun.api.service.impl;

import com.kunlun.api.client.TicketClient;
import com.kunlun.api.service.TicketService;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-04.
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketClient ticketClient;

    /**
     * 新增优惠券
     *
     * @param ticket
     * @return
     */
    @Override
    public DataRet add(Ticket ticket) {
        return ticketClient.add(ticket);
    }
}