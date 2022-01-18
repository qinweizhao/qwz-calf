package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysPostPageQry;
import com.qinweizhao.system.module.manage.entity.SysPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

    /**
     * 通过岗位 Id 集合查询岗位集合
     *
     * @param postIds postIds
     * @return List<SysPost>
     */
    List<SysPost> selectListPosts(List<Long> postIds);

    /**
     * 查询岗位分页数据
     *
     * @param page           page
     * @param sysPostPageQry sysPostPageQry
     * @return IPage<SysPost>
     */
    IPage<SysPost> selectPagePosts(Page<Object> page, @Param("query") SysPostPageQry sysPostPageQry);

    /**
     * 通过岗位名称查询岗位
     *
     * @param postName postName
     * @return SysPost
     */
    SysPost selectPostByPostName(String postName);

    /**
     * 通过岗位编码查询岗位
     *
     * @param postCode postCode
     * @return SysPost
     */
    SysPost selectPostByPostCode(String postCode);
}
