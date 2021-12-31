package com.qinweizhao.common.core.exception;

/**
 * Token处理异常
 *
 * @author qinweizhao.
 * @since 2021/11/18
 */
public class TokenException extends RuntimeException {

    private static final long serialVersionUID = -109638013567525177L;

    public TokenException(String message) {
        super(message);
    }
}
