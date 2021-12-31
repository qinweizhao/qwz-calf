package com.qinweizhao.common.core.exception;

/**
 * 自定义异常
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
public class CustomizeException extends RuntimeException {

    public CustomizeException() {
    }

    public CustomizeException(String msg) {
        super(msg);
    }

}
