package com.qinweizhao.filter;

import cn.hutool.core.util.StrUtil;
import com.qinweizhao.system.service.ISysUserService;
import com.qinweizhao.util.JwtUtils;
import com.qinweizhao.entity.SysUserDetails;
import com.qinweizhao.system.entity.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt 过滤器
 *
 * @author qinweizhao
 * @since 2021/9/25
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /**
     * 日志记录
     */
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private ISysUserService sysUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {
        // 从请求头中获取 token
        String jwt = request.getHeader(jwtUtils.getHeader());
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request, response);
            return;
        }
        Claims claim = jwtUtils.getClaimByToken(jwt);
        if (jwtUtils.isTokenExpired(claim)) {
            throw new JwtException("token已过期");
        }
        String username = claim.getSubject();
        SysUser sysUser = sysUserService.selectUserByUsername(username);
        SysUserDetails sysUserDetails = new SysUserDetails();
        BeanUtils.copyProperties(sysUser, sysUserDetails);
        String authority = sysUserService.getAuthorityByUserId(sysUserDetails.getUserId());
        log.info("当前用户拥有的权限有{}", authority);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }
}
