package com.qinweizhao.common.core.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.entity.SysUserDetails;
import com.qinweizhao.common.core.request.Search;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author qinweizhao
 * @since 2021/11/18
 */
public class BaseController {


    /**
     * 获取 page 对象
     *
     * @param search search
     * @param <T>    search
     * @return T
     */
    public static <T> IPage<T> getPage(Search search) {
        return new Page<>(search.getCurrent(), search.getSize());
    }

    /**
     * 获取当前登录用户的用户名
     *
     * @return String
     */
    public String getCurrentLoginUsername() {
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sysUserDetails.getUsername();
    }

    /**
     * 获取当前登录用户的用户名
     *
     * @return String
     */
    public SysUserDetails getLoginUser() {
        return (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
