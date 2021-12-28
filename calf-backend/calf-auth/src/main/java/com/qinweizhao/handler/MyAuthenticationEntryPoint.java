package com.qinweizhao.handler;

import cn.hutool.json.JSONUtil;
import com.qinweizhao.common.response.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 用来解决匿名用户访问需要权限才能访问的资源时的异常
 *
 * @author qinweizhao
 * @since 2021/9/25
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {


    /**
     * 当用户尝试访问需要权限才能的 REST 资源而不提供 Token 或者 Token 错误或者过期时，将调用此方法发送 401 响应以及错误信息
     *
     * @param httpServletRequest  request
     * @param httpServletResponse response
     * @param e                   authenticationException
     * @throws IOException e
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {

        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        Result<?> response = Result.failure("请求失败，请联系管理员!");
        response.setCode(401);
        outputStream.write(JSONUtil.toJsonStr(response).getBytes(StandardCharsets.UTF_8));

        outputStream.flush();
        outputStream.close();

    }
}
