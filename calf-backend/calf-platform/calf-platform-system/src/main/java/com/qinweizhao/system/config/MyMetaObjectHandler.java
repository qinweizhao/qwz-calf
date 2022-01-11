package com.qinweizhao.system.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.qinweizhao.common.core.util.CalfDefaultValueUtils;
import com.qinweizhao.common.core.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author qinweizhao
 * @since 2021/12/23
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        Integer status = CalfDefaultValueUtils.getStatus();
        log.info("default"+status);
        this
                .strictInsertFill(metaObject, "sort", CalfDefaultValueUtils::getSort, Integer.class)
                .strictInsertFill(metaObject, "deleted", CalfDefaultValueUtils::getDeleted, Integer.class)
                .strictInsertFill(metaObject, "status", CalfDefaultValueUtils::getStatus, Integer.class)
                .strictInsertFill(metaObject, "createBy", SecurityUtils::getLoginUsername, String.class)
                .strictInsertFill(metaObject, "updateBy", SecurityUtils::getLoginUsername, String.class)
                .strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class)
                .strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        // 起始版本 3.3.3(推荐)
        this
                .strictInsertFill(metaObject, "updateBy", SecurityUtils::getLoginUsername, String.class)
                .strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}

