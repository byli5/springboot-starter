package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 */
//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest request,Exception e){
        e.getStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }
}
