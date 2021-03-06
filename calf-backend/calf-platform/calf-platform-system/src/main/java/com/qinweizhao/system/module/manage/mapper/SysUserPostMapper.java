package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysUserPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户与岗位关联表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysUserPostMapper extends BaseMapper<SysUserPost> {

    /**
     * 删除
     *
     * @param ids ids
     * @return int
     */
    int deleteUserPost(@Param("ids") List<Long> ids);

    /**
     * 插入
     *
     * @param list list
     * @return int
     */
    int insertBatchUserPost(@Param("list") List<SysUserPost> list);

    /**
     * 通过用户 Id 查询所属岗位集合
     *
     * @param userId userId
     * @return List<Long>
     */
    List<Long> selectPostIdsByUserId(Long userId);


}
