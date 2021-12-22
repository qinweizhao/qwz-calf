package com.qinweizhao.system.module.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.exception.ServiceException;
import com.qinweizhao.system.module.system.entity.SysDictType;
import com.qinweizhao.system.module.system.mapper.SysDictDataMapper;
import com.qinweizhao.system.module.system.mapper.SysDictTypeMapper;
import com.qinweizhao.system.module.system.service.ISysDictTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.qinweizhao.common.response.ResultCode.*;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {

    @Resource
    SysDictDataMapper sysDictDataMapper;


    @Override
    public int saveDictType(SysDictType sysDictType) {
        // 校验正确性
        this.checkSaveOrUpdate(null, sysDictType.getName(), sysDictType.getType());
        // 插入字典类型
        return this.baseMapper.insert(sysDictType);
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
     * @return SysDictType
     */
    private SysDictType checkDictTypeExists(Long id) {
        if (id == null) {
            return null;
        }
        SysDictType dictType = this.baseMapper.selectById(id);
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
        SysDictType dictType = this.baseMapper.selectDictTypeByName(name);
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
        SysDictType dictType = this.baseMapper.selectDictTypeByType(type);
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
    public int updateDictType(SysDictType sysDictType) {
        // 校验正确性
        this.checkSaveOrUpdate(sysDictType.getId(), sysDictType.getName(), null);
        // 更新字典类型
        return this.baseMapper.updateById(sysDictType);
    }

    @Override
    public int removeDictType(Long id) {
        // 校验是否存在
        SysDictType dictType = this.checkDictTypeExists(id);
        // 校验是否有字典数据
        if (sysDictDataMapper.selectCountByDictType(dictType.getType()) > 0) {
            throw new ServiceException(DICT_TYPE_HAS_CHILDREN);
        }
        // 删除字典类型
        return this.baseMapper.deleteById(id);
    }

    @Override
    public IPage<SysDictType> pageDictTypes(Page<SysDictType> page, SysDictType sysDictType) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        return this.baseMapper.selectPage(page,queryWrapper);
    }
}
