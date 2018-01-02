//package com.kunlun.interceptor;
//
//import com.codingapi.tx.springcloud.interceptor.TxManagerInterceptor;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//
///**
// * @author by kunlun
// * @version <0.1>
// * @created on 2017/12/25.
// */
//@Aspect
//@Component
//public class TxTransactionInterceptor implements Ordered {
//    @Override
//    public int getOrder() {
//        return 1;
//    }
//
//    @Autowired
//    private TxManagerInterceptor txManagerInterceptor;
//
//    @Around("execution(* com.kunlun.api.service.impl.*Impl.*(..))")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        return txManagerInterceptor.around(point);
//    }
//}
