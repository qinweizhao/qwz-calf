package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysRoleMenu;

/**
 * <p>
 * 角色菜单关联 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    int deleteRoleMenuByMenuId(Long menuId);
}
