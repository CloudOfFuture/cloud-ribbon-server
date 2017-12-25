package com.kunlun.api.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.kunlun.api.client.IndexClient;
import com.kunlun.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexClient indexClient;

    @TxTransaction
    @Transactional
    @Override
    public void index(String orderNo) {
        indexClient.index(orderNo);
    }

}
