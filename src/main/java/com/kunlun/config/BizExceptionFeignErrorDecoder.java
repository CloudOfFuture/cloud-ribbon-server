package com.kunlun.config;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import org.springframework.context.annotation.Configuration;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/22.
 */
@Configuration
public class BizExceptionFeignErrorDecoder implements feign.codec.ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            return new HystrixBadRequestException("接口调用异常");
        }
        return feign.FeignException.errorStatus(methodKey, response);
    }
}
