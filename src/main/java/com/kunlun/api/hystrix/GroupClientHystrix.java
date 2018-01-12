package com.kunlun.api.hystrix;

import com.kunlun.api.client.GroupClient;
import com.kunlun.result.DataRet;
import com.kunlun.wxentity.UnifiedRequestData;
import org.springframework.stereotype.Component;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-12.
 */
@Component
public class GroupClientHystrix implements GroupClient {

    /**
     * 参见拼团
     *
     * @param unifiedRequestData
     * @return
     */
    @Override
    public DataRet joinGroup(UnifiedRequestData unifiedRequestData) {
        return new DataRet("ERROR", "参见拼团失败");
    }
}
