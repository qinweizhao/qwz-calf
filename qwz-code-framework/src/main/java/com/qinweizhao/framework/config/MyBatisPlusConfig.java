package com.qinweizhao.framework.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author QinWeiZhao
 * @since 2021-07-13
 */
@MapperScan("com.qinweizhao.security.mapper")
@Configuration
public class MyBatisPlusConfig {
}
