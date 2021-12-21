package com.qinweizhao.system.module.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    int saveDictType(SysDictType sysDictType);

    int updateDictType(SysDictType sysDictType);

    int removeDictType(Long id);

    IPage<SysDictType> pageDictTypes(SysDictType sysDictType);
}
