package com.kunlun.api.service;


import com.kunlun.result.DataRet;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
public interface IndexService {


    DataRet<String> index(String orderNo);
}
