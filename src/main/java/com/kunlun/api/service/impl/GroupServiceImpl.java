package com.kunlun.api.service.impl;

import com.kunlun.api.client.GroupClient;
import com.kunlun.api.service.GroupService;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-12.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupClient groupClient;

    /**
     * 参见拼团
     *
     * @param unifiedRequestData
     * @return
     */
    @Override
    public DataRet joinGroup(UnifiedRequestData unifiedRequestData) {
        return groupClient.joinGroup(unifiedRequestData);
    }
}
