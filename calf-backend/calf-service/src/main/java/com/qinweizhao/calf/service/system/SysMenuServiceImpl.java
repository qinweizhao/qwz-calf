package com.qinweizhao.calf.service.system;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.SysMenuService;
import com.qinweizhao.calf.dao.system.dataobject.SysMenu;
import com.qinweizhao.calf.dao.system.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
