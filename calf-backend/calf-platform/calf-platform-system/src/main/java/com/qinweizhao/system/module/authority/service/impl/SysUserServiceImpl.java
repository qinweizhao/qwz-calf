package com.qinweizhao.system.module.authority.service.impl;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.request.Search;
import com.qinweizhao.system.module.authority.entity.SysUser;
import com.qinweizhao.system.module.authority.mapper.SysUserMapper;
import com.qinweizhao.system.module.authority.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.Map;
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
    public Map<Object, Object> getProjectInitInfo(String currentLoginUsername) {
        SysUser sysUser = baseMapper.selectUserByUsername(currentLoginUsername);
        // 清除密码
        sysUser.setPassword("");
        Long userId = sysUser.getUserId();
        Set<String> roles = this.baseMapper.selectRolesByUserId(userId);
        Set<String> permissions = this.baseMapper.selectPermissionsByUserId(userId);
        return MapUtil.builder()
                .put("user", sysUser)
                .put("roles", roles)
                .put("permissions", permissions).map();
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
