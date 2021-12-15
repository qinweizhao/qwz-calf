package com.qinweizhao.filter;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.qinweizhao.common.constant.Constants;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.common.util.GuavaCacheUtils;
import com.qinweizhao.common.util.IoUtils;
import com.qinweizhao.config.AuthConstants;
import com.qinweizhao.exception.CaptchaException;
import com.qinweizhao.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * @author qinweizhao
 * @since 2021/9/25
 */
@Slf4j
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    /**
     * 登录 url
     */
    private static final String LOGIN_URL = "/login";


    @Resource
    JwtUtils jwtUtils;

    /**
     * 无参构造器
     */
    public MyAuthenticationFilter() {
        setFilterProcessesUrl(LOGIN_URL);
    }


    /**
     * 尝试认证
     *
     * @param request  request
     * @param response response
     * @return Authentication
     * @throws AuthenticationException e
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!HttpMethod.POST.matches(request.getMethod())) {
            throw new AuthenticationServiceException("不支持身份验证方法:" + request.getMethod());
        }
        JSONObject jsonObject = IoUtils.parseRequestToJsonObject(request);
        String captcha = jsonObject.getString(Constants.LOGIN_CODE_KEY);
        if (AuthConstants.IS_CAPTCHA){
            boolean b = this.validateCaptcha(captcha);
            if (!b) {
                throw new CaptchaException("验证码错误");
            }
        }
        String username = jsonObject.getString(Constants.LOGIN_USER_KEY);
        username = username != null ? username : "";
        username = username.trim();
        String password = jsonObject.getString(Constants.LOGIN_PASS_KEY);
        password = password != null ? password : "";

        // 判断 账号 密码 验证码 是否为空
        log.info("当前登录账户：{}", jsonObject);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        return this.getAuthenticationManager().authenticate(token);
    }


    /**
     * 登录成功
     *
     * @param request    request
     * @param response   response
     * @param chain      chain
     * @param authResult authResult
     * @throws IOException      e
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("登录成功");
        }
        // 将认证信息放入 SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authResult);

        System.out.println("=================");
        System.out.println(authResult);
        System.out.println("=================");

        // 生成 token
        String token = jwtUtils.generateToken(authResult.getName());
        Result<String> success = Result.success(token);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(success));
        writer.flush();
        writer.close();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("登录失败");
        }
        Result<?> failure = Result.failure();
        response.setContentType("application/json;charset=utf-8");
        if (exception instanceof CaptchaException){
            failure.setMsg(exception.getMessage());
        }
        if (exception instanceof LockedException) {
            failure.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            failure.setMsg("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            failure.setMsg("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            failure.setMsg("账户被禁用，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            failure.setMsg("用户名或者密码输入错误，请重新输入!");
        }
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(failure));
        writer.flush();
        writer.close();
    }

    /**
     * 校验验证码
     *
     * @param captcha 验证码
     */
    private boolean validateCaptcha(String captcha) {
        if (StringUtils.isEmpty(captcha)) {
            throw new CaptchaException("验证码为空");
        }
        ConcurrentMap<String, String> stringStringConcurrentMap = GuavaCacheUtils.CACHE.asMap();
        Collection<String> values = stringStringConcurrentMap.values();
        boolean b = values.contains(captcha);
        if (b) {
            // 当验证通过后，及时删除当前验证码
            for (Map.Entry<String, String> entry : stringStringConcurrentMap.entrySet()) {
                if (String.valueOf(entry.getValue()).equals(captcha)) {
                    GuavaCacheUtils.CACHE.invalidate(entry.getKey());
                }
            }
        }
        return b;
    }
}
