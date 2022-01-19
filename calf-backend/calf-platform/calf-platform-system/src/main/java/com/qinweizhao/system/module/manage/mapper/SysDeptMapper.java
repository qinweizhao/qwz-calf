package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.api.system.dto.query.SysDeptListQry;
import com.qinweizhao.system.module.manage.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {


    List<SysDept> selectListSimpleDepts(Integer status);


    /**
     * 通过用户名获取部门名称
     *
     * @param userId userId
     * @return String
     */
    String selectnameByUserId(Long userId);

    /**
     * 查询部门列表
     *
     * @param sysDeptListQry sysDeptListQry
     * @return List<SysDept>
     */
    List<SysDept> selectListDepts(@Param("query") SysDeptListQry sysDeptListQry);

    /**
     * 通过父 Id 和部门名称查询部门
     * @param parentId parentId
     * @param name name
     * @return SysDept
     */
    SysDept selectDeptByParentIdAndName( @Param("parentId") Long parentId, @Param("name") String name);

    /**
     * 统计下属部门个数
     * @param deptId deptId
     * @return int
     */
    int selectCountByParentId(Long deptId);

}
