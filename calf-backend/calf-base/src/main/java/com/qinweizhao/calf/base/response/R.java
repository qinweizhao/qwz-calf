package com.qinweizhao.calf.base.response;


import lombok.Data;

import javax.servlet.http.HttpServletResponse;

/**
 * @author qinweizhao
 * @since 2021/9/25
 */
@Data
public class R {

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public R() {

    }

    public R(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static R success(Object data) {
        return success(HttpServletResponse.SC_OK, "操作成功", data);
    }

    public static R success(String message, Object data) {
        return success(HttpServletResponse.SC_OK, message, data);
    }

    public static R success(int code, String message, Object data) {
        return new R(code, message, data);
    }

    public static R failure(String message) {
        return success(HttpServletResponse.SC_BAD_REQUEST, message, null);
    }

    public static R failure(String message, Object data) {
        return success(HttpServletResponse.SC_BAD_REQUEST, message, data);
    }

    public static R failure(int code, String message, Object data) {
        return new R(code, message, data);
    }

}
