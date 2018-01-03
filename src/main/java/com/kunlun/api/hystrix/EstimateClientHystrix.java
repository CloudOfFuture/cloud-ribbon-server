package com.kunlun.api.hystrix;

import com.kunlun.api.client.EstimateClient;
import com.kunlun.entity.Estimate;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-03.
 */
@Component
public class EstimateClientHystrix implements EstimateClient {

    /**
     * 评价
     *
     * @param estimate
     * @return
     */
    @Override
    public DataRet estimate(Estimate estimate) {
        return new DataRet("ERROR", "评价失败");
    }
}
