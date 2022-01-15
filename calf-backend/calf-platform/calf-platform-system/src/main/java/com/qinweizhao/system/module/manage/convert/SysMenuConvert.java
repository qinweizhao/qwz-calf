package com.qinweizhao.system.module.manage.convert;


import com.qinweizhao.api.system.vo.resp.SysMenuVO;
import com.qinweizhao.system.module.manage.entity.SysMenu;
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
     *
     * @param sysMenu sysMenu
     * @return SysMenuVO
     */
    SysMenuVO convert(SysMenu sysMenu);

    /**
     * DO 转 VO
     *
     * @param menuList menuList
     * @return SysMenuVO
     */
    List<SysMenuVO> convert(List<SysMenu> menuList);
}
