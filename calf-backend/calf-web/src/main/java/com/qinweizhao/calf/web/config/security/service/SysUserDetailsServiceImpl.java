package com.qinweizhao.calf.web.config.security.service;


import com.qinweizhao.calf.api.system.SysUserService;
import com.qinweizhao.calf.dao.system.dataobject.SysUser;
import com.qinweizhao.calf.web.config.security.entity.SysUserDetails;
import lombok.extern.slf4j.Slf4j;
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
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser accountInfo = sysUserService.selectUserByUsername(username);
        if (accountInfo == null) {
            throw new UsernameNotFoundException("用户名输入错误");
        }
        SysUserDetails sysUserDetails = new SysUserDetails();
        BeanUtils.copyProperties(accountInfo,sysUserDetails);
        String authority = sysUserService.getAuthorityByUserId(accountInfo.getUserId());
        log.info("当前用户拥有的权限有{}", authority);
        sysUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
        return sysUserDetails;
    }
}
