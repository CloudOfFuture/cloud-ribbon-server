package com.kunlun.api.hystrix;

import com.kunlun.api.service.GoodLogService;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
@Component
public class GoodLogServiceHystrix implements GoodLogService{

    /**
     * 新增商品日志
     *
     * @param goodName
     * @param action
     * @param id
     * @return
     */
    @Override
    public DataRet<String> saveGoodLog(String goodName, String action, Long id) {
        return new DataRet<>("ERROR","新增日志失败");
    }
}
