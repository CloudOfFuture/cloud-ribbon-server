package com.kunlun.api.service;

import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-09.
 */
public interface FreeService {


    /**
     *
     *
     * @param unifiedRequestData
     * @param ipAddress
     * @return
     */
    DataRet apply(UnifiedRequestData unifiedRequestData, String ipAddress);
}
