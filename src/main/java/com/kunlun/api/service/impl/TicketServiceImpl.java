package com.kunlun.api.service.impl;

import com.kunlun.api.client.TicketClient;
import com.kunlun.api.service.TicketService;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
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
        return ticketClient.findByCondition(pageNo, pageSize, searchKey);
    }

    /**
     * 修改优惠券
     *
     * @param ticket
     * @return
     */
    @Override
    public DataRet modifyByTicket(Ticket ticket) {
        return ticketClient.modifyByTicket(ticket);
    }
}
