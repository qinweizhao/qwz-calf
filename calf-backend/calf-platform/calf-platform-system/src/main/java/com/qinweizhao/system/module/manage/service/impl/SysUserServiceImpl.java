package com.qinweizhao.system.module.manage.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.vo.SysUserVO;
import com.qinweizhao.common.core.constant.UserConstants;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.request.Search;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.common.core.util.SecurityUtils;
import com.qinweizhao.system.module.manage.convert.SysDeptConvert;
import com.qinweizhao.system.module.manage.convert.SysUserConvert;
import com.qinweizhao.system.module.manage.entity.*;
import com.qinweizhao.system.module.manage.mapper.*;
import com.qinweizhao.system.module.manage.service.ISysUserService;
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
    public SysUserVO getUserById(Long id) {
        SysUserVO sysUserVO = SysUserConvert.INSTANCE.convert(this.baseMapper.selectById(id));
        List<Long> ids = sysUserPostMapper.selectPostIdsByUserId(id);
        sysUserVO.setPostIds(ids);
        return sysUserVO;
    }

    @Override
    public void updateUserById(SysUserDTO sysUserDTO) {
        this.checkSaveOrUpdate(sysUserDTO.getUserId(), sysUserDTO.getUsername(), sysUserDTO.getPhone(), sysUserDTO.getEmail(),
                sysUserDTO.getDeptId(), sysUserDTO.getPostIds());
        // 更新用户
        this.baseMapper.updateById(SysUserConvert.INSTANCE.convert(sysUserDTO));
    }

    @Override
    public boolean updatePasswordById(Long userId, String password) {
        return this.baseMapper.updatePasswordById(userId, password);
    }

    @Override
    public boolean updateUserStatusById(Long userId, Integer status) {
        return this.baseMapper.updateUserStatusById(userId, status);
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
    public IPage<SysUserVO> pageUsers(Search search, Long deptId) {
        IPage<SysUser> sysUserPage = this.baseMapper.selectPageUsers(PageUtil.getPage(search), search, deptId);
        IPage<SysUserVO> userPage = SysUserConvert.INSTANCE.convert(sysUserPage);
        List<SysUserVO> records = userPage.getRecords();
        records.forEach(item -> {
            item.setDept(SysDeptConvert.INSTANCE.convert(sysDeptMapper.selectById(item.getDeptId())));
            item.setPostIds(sysUserPostMapper.selectPostIdsByUserId(item.getUserId()));
        });
        return userPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int removeUserByIds(List<Long> ids) {
        // 获取当前用户 id
        String username = SecurityUtils.getLoginUsername();
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
    public int saveUser(SysUserDTO sysUserDTO) {
        this.checkSaveOrUpdate(sysUserDTO.getUserId(), sysUserDTO.getUsername(), sysUserDTO.getPhone(), sysUserDTO.getEmail(),
                sysUserDTO.getDeptId(), sysUserDTO.getPostIds());
        SysUser sysUser = SysUserConvert.INSTANCE.convert(sysUserDTO);
        sysUser.setAvatar(UserConstants.DEFAULT_AVATAR);
        // 新增用户信息
        int i = this.baseMapper.insert(sysUser);
        List<Long> postIds = sysUserDTO.getPostIds();
        Long userId = sysUser.getUserId();
        // 新增用户岗位关联
        this.insertUserPost(postIds, userId);
        // 新增用户与角色管理
        List<Long> roleIds = sysUserDTO.getRoleIds();
        this.insertUserRole(roleIds, userId);
        return i;
    }

    private void insertUserRole(List<Long> roleIds, Long userId) {
        if (!roleIds.isEmpty()) {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.isEmpty()) {
                userRoleMapper.insertBatchUserRole(list);
            }
        }
    }

    private void insertUserPost(List<Long> postIds, Long userId) {
        if (!postIds.isEmpty()) {
            // 新增用户与岗位管理
            List<SysUserPost> list = new ArrayList<>();
            for (Long postId : postIds) {
                SysUserPost up = new SysUserPost();
                up.setUserId(userId);
                up.setPostId(postId);
                list.add(up);
            }
            if (!list.isEmpty()) {
                sysUserPostMapper.insertBatchUserPost(list);
            }
        }
    }

}
