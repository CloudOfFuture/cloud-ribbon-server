package com.kunlun.api.service.impl;

import com.kunlun.api.client.EstimateClient;
import com.kunlun.api.service.EstimateService;
import com.kunlun.entity.Estimate;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-03.
 */
@Service
public class EstimateServiceImpl implements EstimateService {

    @Autowired
    private EstimateClient estimateClient;

    /**
     * 评价
     *
     * @param estimate
     * @return
     */
    @Override
    public DataRet estimate(Estimate estimate) {
        return estimateClient.estimate(estimate);
    }
}
