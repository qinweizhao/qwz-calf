package com.qinweizhao.system.module.manage.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.annotations.VisibleForTesting;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.dto.command.SysUserSaveCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdateCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdatePasswordCmd;
import com.qinweizhao.api.system.dto.query.SysUserPageQry;
import com.qinweizhao.common.core.constant.UserConstants;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.CustomizeException;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.common.core.util.ServerUtils;
import com.qinweizhao.system.module.manage.convert.SysUserConvert;
import com.qinweizhao.system.module.manage.entity.*;
import com.qinweizhao.system.module.manage.mapper.*;
import com.qinweizhao.system.module.manage.service.ISysUserService;
import com.qinweizhao.system.module.manage.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Slf4j
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysPostMapper sysPostMapper;

    @Resource
    private SysUserPostMapper sysUserPostMapper;

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ServerUtils serverUtils;

    @Override
    public SysUser selectUserByUsername(String username) {
        return sysUserMapper.selectUserByUsername(username);
    }

    @Override
    public String getAuthorityByUserId(Long userId) {
        String authority = "";
        Set<String> roleSet = sysUserMapper.selectCodesByUserId(userId);
        if (!roleSet.isEmpty()) {
            String roles = roleSet.stream().map(
                    "ROLE_"::concat
            ).collect(Collectors.joining(","));
            log.debug("当前用户拥有的角色有:" + roles);
            authority = authority.concat(",");
        }
        Set<String> permissionSet = sysUserMapper.selectPermissionsByUserId(userId);

        if (!permissionSet.isEmpty()) {
            String permission = String.join(",", permissionSet);
            authority = authority.concat(permission);
        }
        return authority;
    }


    @Override
    public Map<Object, Object> getProjectInitInfo(String currentLoginUsername) {
        SysUser sysUser = sysUserMapper.selectUserByUsername(currentLoginUsername);
        // 清除密码
        sysUser.setPassword("");
        Long userId = sysUser.getUserId();
        Set<String> roles = sysUserMapper.selectCodesByUserId(userId);
        Set<String> permissions;
        if (SecurityUtils.hasAnyAdmin(roles)) {
            permissions = sysMenuMapper.selectListPermission();
        } else {
            permissions = sysUserMapper.selectPermissionsByUserId(userId);
        }
        return MapUtil.builder()
                .put("user", sysUser)
                .put("roles", roles)
                .put("permissions", permissions).map();
    }


    @Override
    public SysUserDTO getUserById(Long id) {
        SysUserDTO sysUserDTO = SysUserConvert.INSTANCE.convert(sysUserMapper.selectById(id));
        List<Long> ids = sysUserPostMapper.selectPostIdsByUserId(id);
        sysUserDTO.setPostIds(ids);
        return sysUserDTO;
    }

    @Override
    public int updateUserById(SysUserUpdateCmd sysUserUpdateCmd) {
        this.checkSaveOrUpdate(sysUserUpdateCmd.getUserId(), sysUserUpdateCmd.getUsername(), sysUserUpdateCmd.getPhone(), sysUserUpdateCmd.getEmail(),
                sysUserUpdateCmd.getDeptId(), sysUserUpdateCmd.getPostIds());
        // 更新用户
        return sysUserMapper.updateById(SysUserConvert.INSTANCE.convert(sysUserUpdateCmd));
    }


    @Override
    public boolean updateUserStatusById(Long userId, Integer status) {
        return sysUserMapper.updateStatusByUserId(userId, status);
    }

    @Override
    public List<Long> listRoleIdsByUserId(Long userId) {
        return sysUserMapper.selectRoleIdsByUserId(userId);
    }

    @Override
    public boolean updateUserRole(Long userId, List<Long> roleIds) {
        // 获得角色拥有角色编号
        List<Long> dbRoleIds = sysUserMapper.selectRoleIdsByUserId(userId);
        // 计算新增和删除的角色编号
        Collection<Long> insertRoleIds = CollUtil.subtract(roleIds, dbRoleIds);
        Collection<Long> deleteRoleIds = CollUtil.subtract(dbRoleIds, roleIds);
        // 执行新增和删除。对于已经授权的角色，不用做任何处理
        List<SysUserRole> insertList = new ArrayList<>();
        if (!CollUtil.isEmpty(insertRoleIds)) {
            insertRoleIds.forEach(item -> {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(item);
                insertList.add(sysUserRole);
            });
            sysUserRoleMapper.insertBatchUserRole(insertList);
        }
        if (!CollUtil.isEmpty(deleteRoleIds)) {
            sysUserRoleMapper.deleteUserRoleByUserIdAndRoleIds(userId, deleteRoleIds);
        }
        return true;
    }

    /**
     * 更新用户头像
     *
     * @param userId userId
     * @param file   file
     * @return String
     */
    @Override
    public int updateAvatar(Long userId, MultipartFile file) throws IOException {
        // 判断文件是否为空，
        if (file.isEmpty()) {
            throw new ServiceException(ResultCode.FILE_DOES_NOT_EXIST);
        }
        String projectPath = System.getProperty("user.dir");;
        // 获取文件存储路径（绝对路径）
        String path = projectPath + "/calf-resource/upload/";
        // 获取原文件名
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + ".png";
        // 创建文件实例
        File filePath = new File(path, fileName);
        log.info("文件{}上传到{}目录成功", fileName, path);
        if (!filePath.getParentFile().exists()) {
            boolean mkdirs = filePath.getParentFile().mkdirs();
            if (!mkdirs) {
                throw new CustomizeException("创建目录失败");
            }
        }
        String avatarPath = serverUtils.getUrl() + "upload/" + fileName;
        // 写入文件
        file.transferTo(filePath);

        this.checkUserExists(userId);

        SysUser sysUser = new SysUser();
        sysUser.setAvatar(avatarPath);
        sysUser.setUserId(userId);
        return sysUserMapper.updateById(sysUser);
    }


    /**
     * 获取当前项目的根目录
     *
     * @return String
     */
    private String getProjectPath() {
        File parentFile = null;
        try {
            String userHome = System.getProperty("user.dir");
            File file = new File(userHome);
            parentFile = file.getParentFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert parentFile != null;
        return parentFile.toString();
    }

    @Override
    public boolean updatePassword(Long userId, SysUserUpdatePasswordCmd sysUserUpdatePasswordCmd) {
        // 校验旧密码密码
        this.checkOldPassword(userId, sysUserUpdatePasswordCmd.getOldPassword());
        // 执行更新
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        // 加密密码
        sysUser.setPassword(passwordEncoder.encode(sysUserUpdatePasswordCmd.getNewPassword()));
        int i = sysUserMapper.updateById(sysUser);
        return i > 0;
    }

    /**
     * 校验旧密码
     *
     * @param userId      用户 id
     * @param oldPassword 旧密码
     */
    @VisibleForTesting
    public void checkOldPassword(Long userId, String oldPassword) {
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            throw new ServiceException(ResultCode.USER_NOT_EXISTS);
        }
        if (!passwordEncoder.matches(oldPassword, sysUser.getPassword())) {
            throw new ServiceException(ResultCode.USER_PASSWORD_FAILED);
        }
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
        SysUser user = sysUserMapper.selectById(id);
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
        SysUser user = sysUserMapper.selectUserByUsername(username);
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
        SysUser user = sysUserMapper.selectByPhone(phone);
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
        SysUser user = sysUserMapper.selectByEmail(email);
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
    public IPage<SysUserDTO> pageUsers(SysUserPageQry sysUserPageQry) {
        IPage<SysUser> sysUserPage = sysUserMapper.selectPageUsers(PageUtil.getPage(sysUserPageQry), sysUserPageQry);
        return SysUserConvert.INSTANCE.convertToDTO(sysUserPage);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int removeUserByIds(List<Long> ids) {
        // 获取当前用户 id
        String username = SecurityUtils.getLoginUsername();
        SysUser sysUser = sysUserMapper.selectUserByUsername(username);
        Long userId = sysUser.getUserId();
        if (ids.contains(userId)) {
            throw new ServiceException("不能删除当前用户");
        }
        // 删除用户与角色关联
        sysUserRoleMapper.deleteUserRole(ids);
        // 删除用户与岗位关联
        sysUserPostMapper.deleteUserPost(ids);
        return sysUserMapper.deleteBatchIds(ids);
    }


    @Override
    public int saveUser(SysUserSaveCmd sysUserSaveCmd) {
        this.checkSaveOrUpdate(null, sysUserSaveCmd.getUsername(), sysUserSaveCmd.getPhone(), sysUserSaveCmd.getEmail(),
                sysUserSaveCmd.getDeptId(), sysUserSaveCmd.getPostIds());
        SysUser sysUser = SysUserConvert.INSTANCE.convert(sysUserSaveCmd);
        sysUser.setAvatar(UserConstants.DEFAULT_AVATAR);
        // 加密密码
        sysUser.setPassword(passwordEncoder.encode(sysUserSaveCmd.getPassword()));
        // 新增用户信息
        int i = sysUserMapper.insert(sysUser);
        List<Long> postIds = sysUserSaveCmd.getPostIds();
        Long userId = sysUser.getUserId();
        // 新增用户岗位关联
        this.insertUserPost(postIds, userId);
        // 新增用户与角色管理
        List<Long> roleIds = sysUserSaveCmd.getRoleIds();
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
            sysUserRoleMapper.insertBatchUserRole(list);
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
            sysUserPostMapper.insertBatchUserPost(list);
        }
    }

}
