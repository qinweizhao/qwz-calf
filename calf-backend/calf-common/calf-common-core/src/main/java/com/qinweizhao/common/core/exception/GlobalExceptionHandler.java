package com.qinweizhao.common.core.exception;

import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.core.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/9/27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(ServiceException.class)
    public Result<?> exception(ServiceException e) {
        e.printStackTrace();
        log.error("Service异常===》ServiceException：", e);
        return Result.failure(ResultCode.ERROR, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> handler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult result = e.getBindingResult();
        ObjectError objectError = result.getAllErrors().stream().findFirst().get();
        log.error("实体校验异常：----------------{}", objectError.getDefaultMessage());
        return Result.failure(ResultCode.ERROR, objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result<?> handler(IllegalArgumentException e) {
        e.printStackTrace();
        log.error("Assert异常：----------------{}", e.getMessage());
        return Result.failure(ResultCode.ERROR, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = CustomizeException.class)
    public Result<?> handler(CustomizeException e) {
        e.printStackTrace();
        log.error("自定义异常：----------------{}", e.getMessage());
        return Result.failure(ResultCode.ERROR, e.getMessage());
    }


    @ExceptionHandler(value = RuntimeException.class)
    public Result<?> handler(RuntimeException e) {
        e.printStackTrace();
        log.error("运行时异常：----------------{}", e.getMessage());
        return Result.failure(ResultCode.ERROR, e.getMessage());
    }


    /**
     * IO 异常
     *
     * @param e e
     * @return CommonResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IOException.class)
    public Result<?> exception(IOException e) {
        e.printStackTrace();
        log.error("全局异常===》IOException异常：", e);
        return Result.failure(ResultCode.ERROR, e.getMessage());
    }

    /**
     * 异常
     *
     * @param e e
     * @return CommonResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Result<?> exception(Exception e) {
        e.printStackTrace();
        log.error("全局异常===》Exception异常：", e);
        return Result.failure(ResultCode.ERROR, e.getMessage());
    }
}
