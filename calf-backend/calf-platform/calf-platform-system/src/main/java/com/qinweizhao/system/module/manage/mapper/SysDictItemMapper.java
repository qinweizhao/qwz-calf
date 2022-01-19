package com.qinweizhao.system.module.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysDictItem;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface SysDictItemMapper extends BaseMapper<SysDictItem> {

    /**
     * 通过字典类型统计字典项个数
     * @param dictType dictType
     * @return int
     */
    int selectCountByDictType(String dictType);
}
