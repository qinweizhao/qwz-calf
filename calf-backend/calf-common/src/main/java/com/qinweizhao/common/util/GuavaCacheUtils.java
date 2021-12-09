package com.qinweizhao.common.util;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author qinweizhao
 * @since 2021/9/27
 */
public class GuavaCacheUtils {

    public static final Cache<String, String> CACHE = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(100)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为60秒
            .expireAfterWrite(60, TimeUnit.SECONDS)
            //构建cache实例
            .build();

    private GuavaCacheUtils() {

    }
}
