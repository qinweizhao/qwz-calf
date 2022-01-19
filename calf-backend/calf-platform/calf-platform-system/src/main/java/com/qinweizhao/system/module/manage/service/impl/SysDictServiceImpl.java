package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.system.module.manage.entity.SysDict;
import com.qinweizhao.system.module.manage.mapper.SysDictItemMapper;
import com.qinweizhao.system.module.manage.mapper.SysDictMapper;
import com.qinweizhao.system.module.manage.service.ISysDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.qinweizhao.common.core.response.ResultCode.*;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Resource
    SysDictItemMapper sysDictItemMapper;


    @Override
    public int saveDictType(SysDict sysDict) {
        // 校验正确性
        this.checkSaveOrUpdate(null, sysDict.getName(), sysDict.getType());
        // 插入字典类型
        return this.baseMapper.insert(sysDict);
    }

    /**
     * 校验正确性
     *
     * @param id   id
     * @param name name
     * @param type type
     */
    private void checkSaveOrUpdate(Long id, String name, String type) {
        // 校验自己存在
        checkDictTypeExists(id);
        // 校验字典类型的名字的唯一性
        checkDictTypeNameUnique(id, name);
        // 校验字典类型的类型的唯一性
        checkDictTypeUnique(id, type);
    }

    /**
     * 检查字典类型是否存在
     *
     * @param id id
     * @return SysDict
     */
    private SysDict checkDictTypeExists(Long id) {
        if (id == null) {
            return null;
        }
        SysDict dictType = this.baseMapper.selectById(id);
        if (dictType == null) {
            throw new ServiceException(DICT_TYPE_NOT_EXISTS);
        }
        return dictType;
    }

    /**
     * 校验字典类型的名字的唯一性
     *
     * @param id   id
     * @param name name
     */
    private void checkDictTypeNameUnique(Long id, String name) {
        SysDict dictType = this.baseMapper.selectDictTypeByName(name);
        if (dictType == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的字典类型
        if (id == null) {
            throw new ServiceException(DICT_TYPE_TYPE_DUPLICATE);
        }
        if (!dictType.getId().equals(id)) {
            throw new ServiceException(DICT_TYPE_TYPE_DUPLICATE);
        }
    }

    /**
     * 校验字典类型的类型的唯一性
     *
     * @param id   id
     * @param type type
     */
    private void checkDictTypeUnique(Long id, String type) {
        SysDict dictType = this.baseMapper.selectDictTypeByType(type);
        if (dictType == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的字典类型
        if (id == null) {
            throw new ServiceException(DICT_TYPE_TYPE_DUPLICATE);
        }
        if (!dictType.getId().equals(id)) {
            throw new ServiceException(DICT_TYPE_TYPE_DUPLICATE);
        }
    }

    @Override
    public int updateDictType(SysDict sysDict) {
        // 校验正确性
        this.checkSaveOrUpdate(sysDict.getId(), sysDict.getName(), null);
        // 更新字典类型
        return this.baseMapper.updateById(sysDict);
    }

    @Override
    public int removeDictType(Long id) {
        // 校验是否存在
        SysDict dictType = this.checkDictTypeExists(id);
        // 校验是否有字典数据
        if (sysDictItemMapper.selectCountByDictType(dictType.getType()) > 0) {
            throw new ServiceException(DICT_TYPE_HAS_CHILDREN);
        }
        // 删除字典类型
        return this.baseMapper.deleteById(id);
    }

    @Override
    public IPage<SysDict> pageDictTypes(Page<SysDict> page, SysDict sysDict) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
