package com.kunlun.api.service.impl;

import com.kunlun.api.client.FreeClient;
import com.kunlun.api.service.FreeService;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-09.
 */
@Service
public class FreeServiceImpl implements FreeService{


    @Autowired
    private FreeClient freeClient;

    /**
     *
     *
     * @param unifiedRequestData
     * @return
     */
    @Override
    public DataRet apply(UnifiedRequestData unifiedRequestData) {
        return freeClient.apply(unifiedRequestData);
    }
}
