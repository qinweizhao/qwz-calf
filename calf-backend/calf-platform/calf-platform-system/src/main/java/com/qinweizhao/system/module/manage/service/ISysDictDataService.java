package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.manage.entity.SysDictData;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface ISysDictDataService extends IService<SysDictData> {

    Long saveDictData(SysDictData sysDictData);

    int updateDictData(SysDictData sysDictData);

    int removeDictData(Long id);

    IPage<SysDictData> pageDictDatas(SysDictData sysDictData);
}
