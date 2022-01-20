package com.qinweizhao.system.module.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysDictItemPageQry;
import com.qinweizhao.system.module.manage.entity.SysDictItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface SysDictItemMapper extends BaseMapper<SysDictItem> {


    IPage<SysDictItem> selectPageDictItems(Page<Object> page, @Param("query") SysDictItemPageQry sysDictItemPageQry);

    /**
     * 通过字典类型统计字典项个数
     *
     * @param dictType dictType
     * @return int
     */
    int selectCountByDictType(String dictType);

    /**
     * 获取字典数据通过字典类型
     *
     * @param dictType dictType
     * @return SysDictItem
     */
    SysDictItem getByDictType(String dictType);

    /**
     * 通过字典类型和 value 获取字典数据
     *
     * @param dictType dictType
     * @return SysDictItem
     */
    SysDictItem selectByDictTypeAndValue(@Param("dictType") String dictType, @Param("value") String value);

    /**
     * 获取部分字典数据 dictType、value、label
     *
     * @return List<SysDictItemDTO>
     */
    List<SysDictItem> selectListSimpleDictItems(Integer status);
}
