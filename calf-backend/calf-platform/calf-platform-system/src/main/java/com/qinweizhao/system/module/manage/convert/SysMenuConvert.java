package com.qinweizhao.system.module.manage.convert;


import com.qinweizhao.api.system.dto.SysMenuDTO;
import com.qinweizhao.api.system.dto.command.SysMenuSaveCmd;
import com.qinweizhao.api.system.dto.command.SysMenuUpdateCmd;
import com.qinweizhao.api.system.vo.SysMenuVO;
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
    SysMenuDTO convert(SysMenu sysMenu);


    /**
     * DO 转 VO
     *
     * @param sysMenuSaveCmd sysMenuSaveCmd
     * @return SysMenuVO
     */
    SysMenu convert(SysMenuSaveCmd sysMenuSaveCmd);

    /**
     * DO 转 VO
     *
     * @param sysMenu sysMenu
     * @return SysMenuVO
     */
    SysMenuVO convert(SysMenuDTO sysMenu);

    /**
     * DTO 转 DO
     *
     * @param sysMenuUpdateCmd sysMenuUpdateCmd
     * @return SysMenuVO
     */
    SysMenu convert(SysMenuUpdateCmd sysMenuUpdateCmd);


    /**
     * DO 转 VO
     *
     * @param menuList menuList
     * @return SysMenuVO
     */
    List<SysMenuDTO> convertToDTO(List<SysMenu> menuList);

    /**
     * DO 转 VO
     *
     * @param menuList menuList
     * @return SysMenuVO
     */
    List<SysMenuVO> convertToVO(List<SysMenuDTO> menuList);
}
