package com.kunlun.api.service;

import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-12.
 */
public interface GroupService {

    /**
     * 参见拼团
     *
     * @param unifiedRequestData
     * @return
     */
    DataRet joinGroup(UnifiedRequestData unifiedRequestData);
}
