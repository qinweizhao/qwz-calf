package com.qinweizhao.system.module.manage.util;


import cn.hutool.core.collection.CollUtil;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.system.module.manage.enums.RoleCodeEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

/**
 * 安全服务工具类
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
public class SecurityUtils {

    /**
     * 获取用户
     **/
    public static String getLoginUsername() {
        try {
            return String.valueOf(getAuthentication().getPrincipal());
        } catch (Exception e) {
            throw new ServiceException("获取用户信息异常");
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param roleList 角色编码集合
     * @return 结果
     */
    public static boolean hasAnyAdmin(Collection<String> roleList) {
        if (CollUtil.isEmpty(roleList)) {
            return false;
        }
        return roleList.stream().anyMatch(item -> RoleCodeEnum.ADMIN.getCode().equals(item));
    }
}
