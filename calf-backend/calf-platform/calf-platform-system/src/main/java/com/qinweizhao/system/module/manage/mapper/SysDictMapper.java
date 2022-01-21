package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysDictPageQry;
import com.qinweizhao.system.module.manage.entity.SysDict;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface SysDictMapper extends BaseMapper<SysDict> {


    /**
     * 通过类型获取字典
     *
     * @param type type
     * @return SysDict
     */
    SysDict selectByType(String type);

    /**
     * 通过字典名称获取字典
     *
     * @param name name
     * @return SysDict
     */
    SysDict selectByName(String name);

    /**
     * 获取分页信息
     *
     * @param page           page
     * @param sysDictPageQry sysDictPageQry
     * @return IPage<SysDict>
     */
    IPage<SysDict> selectPageDicts(Page<Object> page, @Param("query") SysDictPageQry sysDictPageQry);
}
