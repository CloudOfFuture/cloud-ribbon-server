package com.kunlun.api.controller;

import com.kunlun.api.service.TicketService;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 模糊查询优惠券（带分页）
     *
     * @param pageNo    页码
     * @param pageSize  数量
     * @param searchKey 关键字
     * @return
     */
    @GetMapping("/findByCondition")
    public PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                                      @RequestParam(value = "pageSize") Integer pageSize,
                                      @RequestParam(value = "searchKey", required = false) String searchKey) {
        return ticketService.findByCondition(pageNo, pageSize, searchKey);
    }

    /**
     * 修改优惠券
     *
     * @param ticket 优惠券
     * @return
     */
    @PostMapping("/modifyByTicket")
    public DataRet modifyByTicket(@RequestBody Ticket ticket) {
        return ticketService.modifyByTicket(ticket);
    }

    /**
     * 根据主键id删除优惠券
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("deleteById")
    public DataRet deleteById(@RequestParam(value = "id") Long id) {
        return ticketService.deleteById(id);
    }

}
