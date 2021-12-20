package com.qinweizhao.system.module.authority.service.impl;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.exception.ServiceException;
import com.qinweizhao.common.util.SecurityUtils;
import com.qinweizhao.system.module.authority.mapper.SysDeptMapper;
import com.qinweizhao.system.module.authority.mapper.SysUserMapper;
import com.qinweizhao.system.module.authority.mapper.SysUserPostMapper;
import com.qinweizhao.system.module.authority.mapper.SysUserRoleMapper;
import com.qinweizhao.system.module.authority.model.entity.SysUser;
import com.qinweizhao.system.module.authority.model.entity.SysUserPost;
import com.qinweizhao.system.module.authority.model.entity.SysUserRole;
import com.qinweizhao.system.module.authority.model.query.SysUserQuery;
import com.qinweizhao.system.module.authority.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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

    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Resource
    private SysUserPostMapper userPostMapper;
    @Resource
    private SysDeptMapper sysDeptMapper;

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
    public IPage<SysUser> pageUsers(Page<SysUser> page, SysUserQuery sysUserQuery) {
        IPage<SysUser> sysUserPage = this.baseMapper.selectPageUsers(page, sysUserQuery);
        List<SysUser> records = sysUserPage.getRecords();
        records.forEach(item->{
            item.setDept(sysDeptMapper.selectById(item.getDeptId()));
            item.setPostIds(userPostMapper.selectPostIdsByUserId(item.getUserId()));
        });
        return sysUserPage;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int removeUserByIds(List<Long> ids) {
        // 获取当前用户 id
        SysUser loginUser = (SysUser) SecurityUtils.getLoginUser();
        Long userId = loginUser.getUserId();
        if (ids.contains(userId)) {
            throw new ServiceException("不能删除当前用户");
        }
        // 删除用户与角色关联
        userRoleMapper.deleteUserRole(ids);
        // 删除用户与岗位关联
        userPostMapper.deleteUserPost(ids);
        return this.baseMapper.deleteBatchIds(ids);
    }


    @Override
    public int saveUser(SysUser sysUser) {
        // 新增用户岗位关联
        this.insertUserPost(sysUser);
        // 新增用户与角色管理
        this.insertUserRole(sysUser);
        // 新增用户信息
        SysUser user = new SysUser();
        BeanUtils.copyProperties(sysUser,user );
        return this.baseMapper.insert(user);
    }

    private void insertUserRole(SysUser sysUser) {
        List<Long> roleIds = sysUser.getRoleIds();

        if (!roleIds.isEmpty()) {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(sysUser.getUserId());
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.isEmpty()) {
                userRoleMapper.insertBatchUserRole(list);
            }
        }
    }

    private void insertUserPost(SysUser sysUser) {
        List<Long> postIds = sysUser.getPostIds();
        if (!postIds.isEmpty()) {
            // 新增用户与岗位管理
            List<SysUserPost> list = new ArrayList<SysUserPost>();
            for (Long postId : postIds) {
                SysUserPost up = new SysUserPost();
                up.setUserId(sysUser.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            if (!list.isEmpty()) {
                userPostMapper.insertBatchUserPost(list);
            }
        }
    }

}
