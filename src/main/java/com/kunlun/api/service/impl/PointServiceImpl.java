package com.kunlun.api.service.impl;

import com.kunlun.api.client.PointClient;
import com.kunlun.api.service.PointService;
import com.kunlun.entity.Point;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-03.
 */
@Service
public class PointServiceImpl implements PointService{

    @Autowired
    private PointClient pointClient;

    @Override
    public DataRet<Point> findPointByUserId(String userId) {
        return pointClient.findPointByUserId(userId);
    }

    /**
     *
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    @Override
    public PageResult findPointLog(Integer pageNo, Integer pageSize, String wxCode) {
        return null;
    }

    @Override
    public String checkPoint(Integer pointValue, String openid) {
        return pointClient.checkPoint(pointValue,openid);
    }


}
