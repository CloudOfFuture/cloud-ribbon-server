package com.kunlun.api.service.impl;

import com.kunlun.api.client.SendGoodClient;
import com.kunlun.api.service.SendGoodService;
import com.kunlun.entity.SendGood;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-09.
 */
@Service
public class SendGoodServiceImpl implements SendGoodService {

    @Autowired
    private SendGoodClient sendGoodClient;

    /**
     * 新增发货信息
     *
     * @param sendGood
     * @return
     */
    @Override
    public DataRet add(SendGood sendGood) {
        return sendGoodClient.add(sendGood);
    }

    /**
     * 根据id查详情
     *
     * @param id
     * @return
     */
    @Override
    public DataRet findById(Long id) {
        return sendGoodClient.findById(id);
    }
}
