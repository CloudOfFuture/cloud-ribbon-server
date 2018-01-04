package com.kunlun.api.controller;

import com.kunlun.api.service.TicketService;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-04.
 */
@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * 新增优惠券
     *
     * @param ticket 优惠券
     * @return
     */
    @PostMapping("/add")
    public DataRet add(@RequestBody Ticket ticket) {
        return ticketService.add(ticket);
    }
}
