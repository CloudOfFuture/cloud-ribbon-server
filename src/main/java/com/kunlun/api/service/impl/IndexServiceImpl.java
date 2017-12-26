package com.kunlun.api.service.impl;

import com.kunlun.api.client.IndexClient;
import com.kunlun.api.service.IndexService;
import com.kunlun.result.DataRet;
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


    @Transactional
    @Override
    public DataRet<String> index(String orderNo) {

        return indexClient.index(orderNo);
    }

}
