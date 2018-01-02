package com.kunlun.api.hystrix;

import com.kunlun.api.client.BrandClient;
import com.kunlun.entity.Brand;
import com.kunlun.result.DataRet;
import org.springframework.stereotype.Component;

/**
 * @author by fk
 * @version <0.1>
 * @created on 2018-01-02.
 */
@Component
public class BrandClientHystrix implements BrandClient {

    /**
     * 增加品牌
     *
     * @param brand
     * @return
     */
    @Override
    public DataRet add(Brand brand) {
        return new DataRet("ERROR", "增加失败");
    }
}
