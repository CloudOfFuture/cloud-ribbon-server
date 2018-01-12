package com.kunlun.api.service;

import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData; /**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-12.
 */
public interface PayService {


    /**
     * 统一下单
     *
     * @param unifiedRequestData
     * @return
     */
    DataRet<Object> unifiedOrder(UnifiedRequestData unifiedRequestData);
}
