package com.kunlun.api.service;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;


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

    /**
     * 模糊查询优惠券(带分页）
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey);

    /**
     * 修改优惠券
     *
     * @param ticket
     * @return
     */
    DataRet modifyByTicket(Ticket ticket);

    /**
     * 根据主键id删除优惠券
     *
     * @param id
     * @return
     */
    DataRet deleteById(Long id);

    /**
     * 根据主键id删除优惠券
     *
     * @param jsonObject
     * @return
     */
    DataRet batchDeleteById(JSONObject jsonObject);

    /**
     * 根据主键id查询优惠券详情
     *
     * @param id
     * @return
     */
    DataRet findById(Long id);
}
