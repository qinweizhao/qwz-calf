package com.qinweizhao.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 *
 * @author qinweizhao
 * @since 2021/9/27
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String message) {
        super(message);
    }

}

