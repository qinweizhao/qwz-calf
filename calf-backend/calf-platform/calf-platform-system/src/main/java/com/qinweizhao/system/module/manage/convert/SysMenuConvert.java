package com.qinweizhao.system.module.manage.convert;


import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.vo.SysMenuVO;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.api.system.vo.SysUserVO;
import com.qinweizhao.system.module.manage.entity.SysMenu;
import com.qinweizhao.system.module.manage.entity.SysRole;
import com.qinweizhao.system.module.manage.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * (unmappedTargetPolicy = ReportingPolicy.IGNORE)
 *
 * @author qinweizhao
 * @since 2022/1/10
 */
@Mapper
public interface SysMenuConvert {

    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);


    /**
     * DO 转 VO
     * @param sysMenu sysMenu
     * @return SysMenuVO
     */
    SysMenuVO convert(SysMenu sysMenu);

    List<SysMenuVO> convert(List<SysMenu> sysMenus);
}
