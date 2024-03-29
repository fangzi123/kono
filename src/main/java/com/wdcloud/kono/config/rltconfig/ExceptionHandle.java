package com.wdcloud.kono.config.rltconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandle {

    // 用来捕获和处理参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        return new CommonResult(e.getBindingResult().getFieldError().getField()+" " +e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(BindException.class)
    public CommonResult methodArgumentNotValidExceptionHandler(BindException e){
        return new CommonResult(e.getBindingResult().getFieldError().getField()+" " +e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResult exceptionHandler(Exception e){
        log.error("=========异常>\n",e);
        return new CommonResult(Code.ERROR);
    }
}