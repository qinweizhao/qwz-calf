package com.qinweizhao.system.module.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.system.entity.SysDictType;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface ISysDictTypeService extends IService<SysDictType> {

    /**
     * 保存字典类型
     *
     * @param sysDictType sysDictType
     * @return int
     */
    int saveDictType(SysDictType sysDictType);

    /**
     * 修改字典类型
     *
     * @param sysDictType sysDictType
     * @return int
     */
    int updateDictType(SysDictType sysDictType);

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
     * @param sysDictType sysDictType
     * @return IPage<SysDictType>
     */
    IPage<SysDictType> pageDictTypes(Page<SysDictType> page, SysDictType sysDictType);
}
