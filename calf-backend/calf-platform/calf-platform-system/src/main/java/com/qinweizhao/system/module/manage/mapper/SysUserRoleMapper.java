package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {


    /**
     * 批量删除用户和角色关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteUserRole(@Param("ids") List<Long> ids);

    /**
     * 批量新增用户和角色关联
     *
     * @param list list
     */
    int insertBatchUserRole(List<SysUserRole> list);

    /**
     * 通过用户 Id 和 角色 Ids 删除用户和角色关联
     *
     * @param userId  userId
     * @param roleIds roleIds
     * @return int
     */
    int deleteUserRoleByUserIdAndRoleIds(@Param("userId") Long userId, @Param("roleIds") Collection<Long> roleIds);

    /**
     * 通过角色 Id 删除用户和角色关联
     *
     * @param roleId roleId
     * @return int
     */
    int deleteUserRoleByRoleId(Long roleId);
}
