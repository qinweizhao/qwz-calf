package com.qinweizhao.system.module.authority.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.enums.StatusEnum;
import com.qinweizhao.common.exception.ServiceException;
import com.qinweizhao.common.response.ResultCode;
import com.qinweizhao.common.util.SecurityUtils;
import com.qinweizhao.system.module.authority.mapper.*;
import com.qinweizhao.system.module.authority.model.entity.*;
import com.qinweizhao.system.module.authority.service.ISysUserService;
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
    private SysPostMapper sysPostMapper;

    @Resource
    private SysUserPostMapper sysUserPostMapper;

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
    public SysUser getUserById(Long id) {
        SysUser sysUser = this.baseMapper.selectById(id);
        List<Long> ids = sysUserPostMapper.selectPostIdsByUserId(id);
        sysUser.setPostIds(ids);
        return sysUser;
    }

    @Override
    public void updateUserById(SysUser sysUser) {
        this.checkSaveOrUpdate(sysUser.getUserId(), sysUser.getUsername(), sysUser.getPhone(), sysUser.getEmail(),
                sysUser.getDeptId(), sysUser.getPostIds());
        // 更新用户
        this.baseMapper.updateById(sysUser);
    }

    /**
     * 更新或保存前置检查
     *
     * @param id       id
     * @param username username
     * @param phone    phone
     * @param email    email
     * @param deptId   deptId
     * @param postIds  postIds
     */
    private void checkSaveOrUpdate(Long id, String username, String phone, String email,
                                   Long deptId, List<Long> postIds) {
        // 校验用户存在
        this.checkUserExists(id);
        // 校验用户名唯一
        this.checkUsernameUnique(id, username);
        // 校验手机号唯一
        this.checkPhoneUnique(id, phone);
        // 校验邮箱唯一
        this.checkEmailUnique(id, email);
        // 校验部门处于开启状态
        this.checkDeptEnable(deptId);
        // 校验岗位处于开启状态
        this.checkPostEnable(postIds);
    }


    /**
     * 校验用户存在
     *
     * @param id id
     */
    public void checkUserExists(Long id) {
        if (id == null) {
            return;
        }
        SysUser user = this.baseMapper.selectById(id);
        if (user == null) {
            throw new ServiceException(ResultCode.USER_NOT_EXISTS);
        }
    }


    /**
     * 校验用户名唯一
     *
     * @param id       id
     * @param username username
     */
    public void checkUsernameUnique(Long id, String username) {
        if (StrUtil.isBlank(username)) {
            return;
        }
        SysUser user = this.baseMapper.selectUserByUsername(username);
        if (user == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的用户
        if (id == null) {
            throw new ServiceException(ResultCode.USER_USERNAME_EXISTS);
        }
        if (!user.getUserId().equals(id)) {
            throw new ServiceException(ResultCode.USER_USERNAME_EXISTS);
        }
    }

    /**
     * 校验手机号唯一
     *
     * @param id    id
     * @param phone phone
     */
    public void checkPhoneUnique(Long id, String phone) {
        if (StrUtil.isBlank(phone)) {
            return;
        }
        SysUser user = this.baseMapper.selectUserByPhone(phone);
        if (user == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的用户
        if (id == null) {
            throw new ServiceException(ResultCode.USER_MOBILE_EXISTS);
        }
        if (!user.getUserId().equals(id)) {
            throw new ServiceException(ResultCode.USER_MOBILE_EXISTS);
        }
    }

    /**
     * 校验邮箱唯一
     *
     * @param id    id
     * @param email email
     */
    public void checkEmailUnique(Long id, String email) {
        if (StrUtil.isBlank(email)) {
            return;
        }
        SysUser user = baseMapper.selectUserByEmail(email);
        if (user == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的用户
        if (id == null) {
            throw new ServiceException(ResultCode.USER_EMAIL_EXISTS);
        }
        if (!user.getUserId().equals(id)) {
            throw new ServiceException(ResultCode.USER_EMAIL_EXISTS);
        }
    }

    /**
     * 校验部门处于开启状态
     *
     * @param deptId deptId
     */
    public void checkDeptEnable(Long deptId) {
        // 允许不选择
        if (deptId == null) {
            return;
        }
        SysDept dept = sysDeptMapper.selectById(deptId);
        if (dept == null) {
            throw new ServiceException(ResultCode.DEPT_NOT_FOUND);
        }
        if (!StatusEnum.ENABLE.getStatus().equals(dept.getStatus())) {
            throw new ServiceException(ResultCode.DEPT_NOT_ENABLE);
        }
    }


    public void checkPostEnable(List<Long> postIds) {
        // 允许不选择
        if (CollUtil.isEmpty(postIds)) {
            return;
        }
        List<SysPost> posts = sysPostMapper.selectListPosts(postIds);
        if (CollUtil.isEmpty(posts)) {
            throw new ServiceException(ResultCode.POST_NOT_FOUND);
        }
        Map<Long, SysPost> postMap = posts.stream().collect(Collectors.toMap(SysPost::getPostId, t -> t));
        postIds.forEach(postId -> {
            SysPost post = postMap.get(postId);
            if (post == null) {
                throw new ServiceException(ResultCode.POST_NOT_FOUND);
            }
            if (!StatusEnum.ENABLE.getStatus().equals(post.getStatus())) {
                throw new ServiceException(ResultCode.POST_NOT_ENABLE);
            }
        });
    }

    @Override
    public IPage<SysUser> pageUsers(Page<SysUser> page, SysUser sysUser) {
        IPage<SysUser> sysUserPage = this.baseMapper.selectPageUsers(page, sysUser);
        List<SysUser> records = sysUserPage.getRecords();
        records.forEach(item -> {
            item.setDept(sysDeptMapper.selectById(item.getDeptId()));
            item.setPostIds(sysUserPostMapper.selectPostIdsByUserId(item.getUserId()));
        });
        return sysUserPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int removeUserByIds(List<Long> ids) {
        // 获取当前用户 id
        String username = (String) SecurityUtils.getLoginUsername();
        SysUser sysUser = this.baseMapper.selectUserByUsername(username);
        Long userId = sysUser.getUserId();
        if (ids.contains(userId)) {
            throw new ServiceException("不能删除当前用户");
        }
        // 删除用户与角色关联
        userRoleMapper.deleteUserRole(ids);
        // 删除用户与岗位关联
        sysUserPostMapper.deleteUserPost(ids);
        return this.baseMapper.deleteBatchIds(ids);
    }


    @Override
    public int saveUser(SysUser sysUser) {
        // 新增用户信息
        int i = this.baseMapper.insert(sysUser);
        // 新增用户岗位关联
        this.insertUserPost(sysUser);
        // 新增用户与角色管理
        this.insertUserRole(sysUser);
        return i;
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
            List<SysUserPost> list = new ArrayList<>();
            for (Long postId : postIds) {
                SysUserPost up = new SysUserPost();
                up.setUserId(sysUser.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            if (!list.isEmpty()) {
                sysUserPostMapper.insertBatchUserPost(list);
            }
        }
    }

}
