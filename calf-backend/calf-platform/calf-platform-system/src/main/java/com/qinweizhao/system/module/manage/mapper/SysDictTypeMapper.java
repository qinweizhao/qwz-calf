package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysDictType;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    SysDictType selectDictTypeByType(String type);

    SysDictType selectDictTypeByName(String name);
}
