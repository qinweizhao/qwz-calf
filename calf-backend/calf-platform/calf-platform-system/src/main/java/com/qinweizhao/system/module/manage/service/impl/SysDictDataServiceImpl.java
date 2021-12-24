package com.qinweizhao.system.module.manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.manage.mapper.SysDictDataMapper;
import com.qinweizhao.system.module.manage.service.ISysDictDataService;
import com.qinweizhao.system.module.manage.entity.SysDictData;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {


    @Override
    public Long saveDictData(SysDictData sysDictData) {
        return null;
    }

    @Override
    public int updateDictData(SysDictData sysDictData) {
        return 0;
    }

    @Override
    public int removeDictData(Long id) {
        return 0;
    }

    @Override
    public IPage<SysDictData> pageDictDatas(SysDictData sysDictData) {
        return null;
    }
}
