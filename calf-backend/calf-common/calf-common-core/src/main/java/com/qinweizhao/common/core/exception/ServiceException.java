package com.qinweizhao.common.core.exception;


import com.qinweizhao.common.core.response.ResultCode;

/**
 * 业务异常
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
public final class ServiceException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 错误明细，内部调试错误
     */
    private String detailMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException() {
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(ResultCode resultCode) {
        this.message = resultCode.getMsg();
        this.code = resultCode.getCode();
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public ServiceException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }
}