package com.kunlun.api.client;

import com.kunlun.api.hystrix.TicketClientHystrix;
import com.kunlun.entity.Ticket;
import com.kunlun.result.DataRet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
