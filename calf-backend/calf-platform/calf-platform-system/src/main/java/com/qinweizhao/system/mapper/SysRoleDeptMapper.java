package com.qinweizhao.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.entity.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;

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

}
