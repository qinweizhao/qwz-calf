package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysPost;
import org.apache.ibatis.annotations.Mapper;

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

    List<SysPost> selectListPosts(List<Long> postIds);

}
