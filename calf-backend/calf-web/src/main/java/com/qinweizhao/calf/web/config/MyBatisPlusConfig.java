package com.qinweizhao.calf.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qinweizhao
 * @since 2021/9/26
 */
@Configuration
@MapperScan("com.qinweizhao.calf.dao.system.mapper")
public class MyBatisPlusConfig {

    /**
     * 最新版
     *
     * @return MybatisPlusInterceptor
     */
    //@Bean
    //public MybatisPlusInterceptor mybatisPlusInterceptor() {
    //    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    //    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
    //    return interceptor;
    //}
}
