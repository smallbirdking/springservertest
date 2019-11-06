package com.example.demo.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceHandler {

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResponse unKnowExceptionHandler(Exception e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if(elements.length > 0){
            StackTraceElement element = elements[0];
            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if(StringUtils.isBlank(message)){
            message = e.toString();
        }
        BaseResponse response = new BaseResponse();

        response.setCode("4000");
        response.setMsg(message);

        return response;
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(value = LoginException.class)
    public BaseResponse loginExceptionHandler(LoginException e) {
        e.printStackTrace();
        BaseResponse response = new BaseResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMsg());
        return response;
    }
}
