package com.qinweizhao.service;


import com.qinweizhao.entity.SysUserDetails;
import com.qinweizhao.system.entity.SysUser;
import com.qinweizhao.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author qinweizhao
 * @since 2021/9/25
 */
@Slf4j
@Service("sysUserDetailsService")
public class SysUserDetailsServiceImpl implements UserDetailsService {


    @Resource
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long userId = sysUserService.selectUserIdByUsername(username);
        if (userId == null) {
            throw new UsernameNotFoundException("用户名输入错误");
        }
        SysUserDetails sysUserDetails = new SysUserDetails();
        sysUserDetails.setUserId(userId);
        String authority = sysUserService.getAuthorityByUserId(userId);
        log.info("当前用户拥有的权限有{}", authority);
        sysUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
        return sysUserDetails;
    }
}
