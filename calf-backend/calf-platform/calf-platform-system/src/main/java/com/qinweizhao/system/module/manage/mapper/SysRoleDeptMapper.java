package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 角色和部门关联表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {

    /**
     * 查询部门 Ids
     *
     * @param roleId roleId
     * @return List<Long>
     */
    List<Long> selectDeptIdsByRoleId(Long roleId);

    /**
     * 删除角色部门关联
     *
     * @param roleId        roleId
     * @param deleteRoleIds deleteRoleIds
     */
    void deleteRoleDeptByRoleIdAndDeptIds(@Param("roleId") Long roleId, @Param("deptIds") Collection<Long> deleteRoleIds);


    /**
     * 删除
     * @param deptId deptId
     */
    void deleteRoleDeptByDeptId(Long deptId);
}
