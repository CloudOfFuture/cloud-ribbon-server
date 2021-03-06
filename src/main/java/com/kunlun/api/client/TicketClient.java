package com.kunlun.api.client;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.hystrix.TicketClientHystrix;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-04.
 */
@FeignClient(value = "cloud-service-common", fallback = TicketClientHystrix.class)
public interface TicketClient {

    /**
     * 新增优惠券
     *
     * @param ticket
     * @return
     */
    @PostMapping("/ticket/add")
    DataRet add(@RequestBody Ticket ticket);

    /**
     * 模糊查询优惠券（带分页）
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @GetMapping("/ticket/findByCondition")
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "searchKey", required = false) String searchKey);

    /**
     * 修改优惠券
     *
     * @param ticket
     * @return
     */
    @PostMapping("/ticket/modifyByTicket")
    DataRet modifyByTicket(@RequestBody Ticket ticket);

    /**
     * 根据主键id删除优惠券
     *
     * @param id
     * @return
     */
    @GetMapping("/ticket/deleteById")
    DataRet deleteById(@RequestParam(value = "id") Long id);

    /**
     * 根据主键id批量删除优惠券
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/ticket/batchDeleteById")
    DataRet batchDeleteById(@RequestBody JSONObject jsonObject);

    /**
     * 根据主键id查询优惠券详情
     *
     * @param id
     * @return
     */
    @GetMapping("/ticket/findById")
    DataRet findById(@RequestParam(value = "id") Long id);
}
