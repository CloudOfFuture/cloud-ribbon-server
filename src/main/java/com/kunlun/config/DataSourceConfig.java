package com.kunlun.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */
@Configuration
public class DataSourceConfig implements EnvironmentAware {


    private RelaxedPropertyResolver relaxedPropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

//    @Bean
//    public LCNTransactionDataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(relaxedPropertyResolver.getProperty("url"));
//        dataSource.setUsername(relaxedPropertyResolver.getProperty("username"));
//        dataSource.setPassword(relaxedPropertyResolver.getProperty("password"));
//        dataSource.setDriverClassName(relaxedPropertyResolver.getProperty("driver-class-name"));
//        dataSource.setInitialSize(Integer.parseInt(relaxedPropertyResolver.getProperty("initialSize")));
//        dataSource.setMinIdle(Integer.valueOf(relaxedPropertyResolver.getProperty("minIdle")));
//        dataSource.setMaxWait(Long.valueOf(relaxedPropertyResolver.getProperty("maxWait")));
//        dataSource.setMaxActive(Integer.valueOf(relaxedPropertyResolver.getProperty("maxActive")));
//        dataSource.setPoolPreparedStatements(
//                Boolean.valueOf(relaxedPropertyResolver.getProperty("poolPreparedStatements")));
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(
//                Integer.valueOf(relaxedPropertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize")));
//        LCNTransactionDataSource dataSourceProxy = new LCNTransactionDataSource();
//        dataSourceProxy.setDataSource(dataSource);
//        dataSourceProxy.setMaxCount(10);
//        return dataSourceProxy;
//    }

    @Bean
    public DataSource datasource1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(relaxedPropertyResolver.getProperty("url"));
        dataSource.setUsername(relaxedPropertyResolver.getProperty("username"));
        dataSource.setPassword(relaxedPropertyResolver.getProperty("password"));
        dataSource.setDriverClassName(relaxedPropertyResolver.getProperty("driver-class-name"));
        dataSource.setInitialSize(Integer.parseInt(relaxedPropertyResolver.getProperty("initialSize")));
        dataSource.setMinIdle(Integer.valueOf(relaxedPropertyResolver.getProperty("minIdle")));
        dataSource.setMaxWait(Long.valueOf(relaxedPropertyResolver.getProperty("maxWait")));
        dataSource.setMaxActive(Integer.valueOf(relaxedPropertyResolver.getProperty("maxActive")));
        dataSource.setPoolPreparedStatements(
                Boolean.valueOf(relaxedPropertyResolver.getProperty("poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(
                Integer.valueOf(relaxedPropertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        return dataSource;
    }
}
