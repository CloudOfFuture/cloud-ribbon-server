package com.kunlun.api.hystrix;

import com.kunlun.api.client.TicketClient;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return new PageResult("ERROR", "查询失败");
    }

    /**
     * 修改优惠券
     *
     * @param ticket
     * @return
     */
    @Override
    public DataRet modifyByTicket(Ticket ticket) {
        return new DataRet("ERROR", "修改优惠券失败");
    }

    /**
     * 根据主键id删除优惠券
     *
     * @param id
     * @return
     */
    @Override
    public DataRet deleteById(Long id) {
        return new DataRet("ERROR", "删除优惠卷失败");
    }

    /**
     * 根据主键id批量删除优惠券
     *
     * @param list
     * @return
     */
    @Override
    public DataRet batchDeleteById(List<Long> list) {
        return new DataRet("ERROR", "批量删除优惠券失败");
    }
}
