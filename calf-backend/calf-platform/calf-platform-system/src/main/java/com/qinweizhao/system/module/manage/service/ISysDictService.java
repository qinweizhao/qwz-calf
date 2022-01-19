package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.manage.entity.SysDict;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 保存字典类型
     *
     * @param sysDict sysDict
     * @return int
     */
    int saveDictType(SysDict sysDict);

    /**
     * 修改字典类型
     *
     * @param sysDict sysDict
     * @return int
     */
    int updateDictType(SysDict sysDict);

    /**
     * 删除字典类型
     *
     * @param id id
     * @return int
     */
    int removeDictType(Long id);

    /**
     * 分页
     *
     * @param sysDict sysDict
     * @return IPage<SysDict>
     */
    IPage<SysDict> pageDictTypes(Page<SysDict> page, SysDict sysDict);
}
