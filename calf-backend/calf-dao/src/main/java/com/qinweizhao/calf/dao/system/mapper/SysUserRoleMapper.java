package com.qinweizhao.calf.dao.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.calf.dao.system.dataobject.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

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

}
