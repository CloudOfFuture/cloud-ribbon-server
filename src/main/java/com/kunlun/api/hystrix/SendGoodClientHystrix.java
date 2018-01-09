package com.kunlun.api.hystrix;

import com.kunlun.api.client.SendGoodClient;
import com.kunlun.entity.SendGood;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-09.
 */
@Component
public class SendGoodClientHystrix implements SendGoodClient {

    /**
     * 新增发货信息
     *
     * @param sendGood
     * @return
     */
    @Override
    public DataRet add(SendGood sendGood) {
        return new DataRet("ERROR", "新增发货信息失败");
    }

    /**
     * 根据id查详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet findById(Long id) {
        return new DataRet("ERROR", "查询详情出错");
    }
}
