//package com.kunlun.config;
//
//import feign.codec.Encoder;
//import feign.form.spring.SpringFormEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Scope;
//
///**
// * @author JackSpeed
// * @version V1.0 <>
// * @date 17-12-26下午6:12
// * @desc
// */
//@Configuration
//public class FeignMultipartConfig {
//
//    @Bean
//    @Primary
//    @Scope("prototype")
//    public Encoder multipartFormEncoder() {
//        return new SpringFormEncoder();
//    }
//}
