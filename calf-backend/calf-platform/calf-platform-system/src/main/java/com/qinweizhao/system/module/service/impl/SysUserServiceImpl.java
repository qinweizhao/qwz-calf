package com.qinweizhao.system.module.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.request.Search;
import com.qinweizhao.system.module.entity.SysUser;
import com.qinweizhao.system.module.mapper.SysUserMapper;
import com.qinweizhao.system.module.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser selectUserByUsername(String username) {
        return this.baseMapper.selectUserByUsername(username);
    }

    @Override
    public String getAuthorityByUserId(Long userId) {
        String authority = "";
        Set<String> roleSet = this.baseMapper.selectRolesByUserId(userId);
        if (!roleSet.isEmpty()) {
            String roles = roleSet.stream().map("ROLE_"::concat).collect(Collectors.joining(","));
            log.debug("当前用户拥有的角色有:" + roles);
            authority = authority.concat(",");
        }
        Set<String> permissionSet = this.baseMapper.selectPermissionsByUserId(userId);

        if (!permissionSet.isEmpty()) {
            String permission = String.join(",", permissionSet);
            authority = authority.concat(permission);
        }
        return authority;
    }

    @Override
    public Long selectUserIdByUsername(String username) {
        return this.baseMapper.selectUserIdByUsername(username);
    }

    @Override
    public Object listPage(Search search, SysUser sysUser) {
        return null;
    }

    @Override
    public boolean status(String ids, String status) {
        return true;
    }
}
