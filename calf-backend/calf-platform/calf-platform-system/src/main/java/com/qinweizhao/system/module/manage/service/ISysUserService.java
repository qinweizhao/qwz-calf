package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.dto.command.SysUserSaveCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdateCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdatePasswordCmd;
import com.qinweizhao.api.system.dto.query.SysUserPageQry;
import com.qinweizhao.system.module.manage.entity.SysUser;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysUserService {

    /**
     * 通过用户名查询用户
     *
     * @param username 　username
     * @return SysUser
     */
    SysUser selectUserByUsername(String username);

    /**
     * 通过用户 id 获取权限信息
     *
     * @param userId userId
     * @return String
     */
    String getAuthorityByUserId(Long userId);

    /**
     * 获取项目初始化需要的信息
     *
     * @param currentLoginUsername 当前登录的用户名
     * @return user roles permissions
     */
    Map<Object, Object> getProjectInitInfo(String currentLoginUsername);

    /**
     * 获取用户分页信息
     *
     * @param sysUserPageQry sysUserPageQry
     * @return IPage<SysUser>
     */
    IPage<SysUserDTO> pageUsers(SysUserPageQry sysUserPageQry);

    /**
     * 通过用户 Id 集合删除用户
     *
     * @param ids ids
     * @return int
     */
    int removeUserByIds(List<Long> ids);

    /**
     * 保存用户
     *
     * @param sysUserSaveCmd sysUserSaveCmd
     * @return int
     */
    int saveUser(SysUserSaveCmd sysUserSaveCmd);

    /**
     * 通过用户 Id 获取用户
     *
     * @param id id
     * @return SysUserVO
     */
    SysUserDTO getUserById(Long id);

    /**
     * 通过用户 Id 修改用户
     *
     * @param sysUserUpdateCmd sysUserUpdateCmd
     * @return int
     */
    int updateUserById(SysUserUpdateCmd sysUserUpdateCmd);

    /**
     * 通过用户 Id 修改用户状态
     *
     * @param userId userId
     * @param status status
     * @return boolean
     */
    boolean updateUserStatusById(Long userId, Integer status);

    /**
     * 获取用户拥有的角色 Id 集合
     *
     * @param userId Id
     * @return List<Long>
     */
    List<Long> listRoleIdsByUserId(Long userId);

    /**
     * 更改用户所属角色
     *
     * @param userId  userId
     * @param roleIds roleIds
     * @return boolean
     */
    boolean updateUserRole(Long userId, List<Long> roleIds);

    /**
     * 更新用户头像
     *
     * @param userId userId
     * @param file   file
     * @return String
     */
    int updateAvatar(Long userId, MultipartFile file) throws IOException;

    boolean updatePassword(Long userId, SysUserUpdatePasswordCmd sysUserUpdatePasswordCmd);
}
