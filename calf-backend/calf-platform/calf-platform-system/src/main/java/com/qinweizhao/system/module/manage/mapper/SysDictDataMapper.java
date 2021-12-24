package com.qinweizhao.system.module.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysDictData;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    int selectCountByDictType(String type);
}
