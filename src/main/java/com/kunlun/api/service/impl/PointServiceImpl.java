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

    /**
     * 获取积分详情
     *
     * @param userId
     * @return
     */
    @Override
    public DataRet<Point> findPointByUserId(String userId) {
        return pointClient.findPointByUserId(userId);
    }

    /**
     *获取积分记录
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    @Override
    public PageResult findPointLog(Integer pageNo, Integer pageSize, String wxCode) {
        return pointClient.findPointLog(pageNo,pageSize,wxCode);
    }


    /**
     * 操作积分
     *
     * @param point
     * @param userId
     * @return
     */
    @Override
    public DataRet<String> updatePoint(Integer point, String userId) {
        return pointClient.updatePoint(point,userId);
    }

    /**
     * 积分校验
     *
     * @param pointValue
     * @param openid
     * @return
     */
    @Override
    public DataRet<String> checkPoint(Integer pointValue, String openid) {
        return pointClient.checkPoint(pointValue,openid);
    }


}
