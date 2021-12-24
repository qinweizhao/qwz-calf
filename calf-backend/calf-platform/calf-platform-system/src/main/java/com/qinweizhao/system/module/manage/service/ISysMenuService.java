package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.manage.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> listWithTree(String currentLoginUsername);

    Integer saveMenu(SysMenu sysMenu);

    Integer updateMenu(SysMenu sysMenu);

    Integer removeMenuByMenuId(Long id);
}
