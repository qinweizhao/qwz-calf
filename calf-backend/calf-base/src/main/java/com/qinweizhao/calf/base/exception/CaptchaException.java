package com.qinweizhao.calf.base.exception;

/**
 * 验证码异常
 *
 * @author qinweizhao
 * @since 2021/9/27
 */
public class CaptchaException extends RuntimeException {

    public CaptchaException(String message) {
        super(message);
    }

}

