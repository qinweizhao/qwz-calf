package com.qinweizhao.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qinweizhao
 */
@MapperScan("com.qinweizhao.**.mapper")
@Configuration
public class MybatisPlusConfig {
}
