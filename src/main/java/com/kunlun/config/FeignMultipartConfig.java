package com.kunlun.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26下午6:12
 * @desc
 */
public class FeignMultipartConfig {
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
