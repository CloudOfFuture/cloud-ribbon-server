package com.kunlun.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.config.HystrixConfiguration;
import com.netflix.ribbon.Ribbon;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonEagerLoadProperties;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancedRetryPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/19.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Value("${eureka.client.service-url.defaultZone}")
    private String serviceUrl;
    @Bean
    Request.Options feignOptions() {
        return new Request.Options(/***connectTimeoutMills***/10 * 1000,/***readTimeoutMills***/10 * 1000);
    }


    /**
     * Feign  不使用重试机制
     *
     * @return
     */
    @Bean
    Retryer feignRetryer() {

        return Retryer.NEVER_RETRY;
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 消息转换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.MapSortField);
        //解决浏览器返回 content-type格式错误
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
        super.configureMessageConverters(converters);
    }

    /**
     * 解决跨域问题
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

    /**
     * 禁用安全模式,springBoot1.4以后默认开启安全端点模式,需要配置禁止
     */
    @Bean
    public void managementServerProperties(){
        new ManagementServerProperties().getSecurity().setEnabled(false);
    }

    @Bean
    public EurekaClientConfigBean eurekaClientConfigBean(){
        EurekaClientConfigBean eurekaClientConfigBean = new EurekaClientConfigBean();
        Map eurekaMap = new HashMap(2);
        eurekaMap.put("defaultZone",serviceUrl);
        eurekaClientConfigBean.setServiceUrl(eurekaMap);
        return eurekaClientConfigBean;
    }


}
