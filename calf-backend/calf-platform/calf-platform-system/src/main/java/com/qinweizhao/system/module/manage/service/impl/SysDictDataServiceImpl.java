package com.qinweizhao.system.module.manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.manage.entity.SysDictItem;
import com.qinweizhao.system.module.manage.mapper.SysDictItemMapper;
import com.qinweizhao.system.module.manage.service.ISysDictDataService;
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
public class SysDictDataServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictDataService {


    @Override
    public Long saveDictData(SysDictItem sysDictItem) {
        return null;
    }

    @Override
    public int updateDictData(SysDictItem sysDictItem) {
        return 0;
    }

    @Override
    public int removeDictData(Long id) {
        return 0;
    }

    @Override
    public IPage<SysDictItem> pageDictDatas(SysDictItem sysDictItem) {
        return null;
    }
}
