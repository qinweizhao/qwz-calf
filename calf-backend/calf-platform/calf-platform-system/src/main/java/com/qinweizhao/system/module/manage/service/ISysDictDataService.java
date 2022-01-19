package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.manage.entity.SysDictItem;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface ISysDictDataService extends IService<SysDictItem> {

    Long saveDictData(SysDictItem sysDictItem);

    int updateDictData(SysDictItem sysDictItem);

    int removeDictData(Long id);

    IPage<SysDictItem> pageDictDatas(SysDictItem sysDictItem);
}
