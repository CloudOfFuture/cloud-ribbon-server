package com.kunlun.config;

import com.kunlun.result.DataRet;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/25.
 */
@ControllerAdvice
public class GlobalException {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private DataRet<String> internalServerError() {
        return new DataRet<>("ERROR", "服务宕机");
    }
}
