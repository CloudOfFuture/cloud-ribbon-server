package com.kunlun.api.service;

import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

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
     * @param request
     * @return
     */
    DataRet apply(UnifiedRequestData unifiedRequestData, HttpServletRequest request);
}
