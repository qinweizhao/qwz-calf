package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysDict;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    SysDict selectDictTypeByType(String type);

    SysDict selectDictTypeByName(String name);
}
