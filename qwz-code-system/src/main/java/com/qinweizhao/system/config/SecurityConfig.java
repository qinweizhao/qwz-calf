package com.qinweizhao.system.config;

import com.qinweizhao.system.filter.JwtFilter;
import com.qinweizhao.system.filter.JwtLoginFilter;
import com.qinweizhao.system.handler.MyAccessDeniedHandlerImpl;
import com.qinweizhao.system.handler.MyAuthenticationEntryPointImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    private static final String[] URL_WHITELIST = {


            "/captcha"

    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.formLogin().and()
                //禁用session和csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .csrf().disable()
                .authorizeRequests()
                //配置拦截规则
                .antMatchers(URL_WHITELIST).permitAll()
                //其余请求需要认证
                .anyRequest().authenticated()

                .and()
                .exceptionHandling()
                //授权失败处理器
                .accessDeniedHandler(new MyAccessDeniedHandlerImpl())
                //认证失败处理类
                .authenticationEntryPoint(new MyAuthenticationEntryPointImpl())

                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
