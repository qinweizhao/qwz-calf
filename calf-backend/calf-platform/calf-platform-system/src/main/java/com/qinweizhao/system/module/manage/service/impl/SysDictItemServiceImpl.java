package com.qinweizhao.system.module.manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysDictItemDTO;
import com.qinweizhao.api.system.dto.command.SysDictItemSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictItemUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDictItemPageQry;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysDictItemConvert;
import com.qinweizhao.system.module.manage.entity.SysDictItem;
import com.qinweizhao.system.module.manage.mapper.SysDictItemMapper;
import com.qinweizhao.system.module.manage.service.ISysDictItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Service
public class SysDictItemServiceImpl implements ISysDictItemService {

    @Resource
    private SysDictItemMapper sysDictItemMapper;

    @Override
    public int saveDictData(SysDictItemSaveCmd sysDictItemSaveCmd) {
        // 校验正确性
        this.checkCreateOrUpdate(null, sysDictItemSaveCmd.getValue(), sysDictItemSaveCmd.getDictType());
        // 插入字典类型
        SysDictItem sysDictItem = SysDictItemConvert.INSTANCE.convert(sysDictItemSaveCmd);
        return sysDictItemMapper.insert(sysDictItem);
    }

    private void checkCreateOrUpdate(Long id, String value, String dictType) {
        // 校验自己存在
        checkDictDataExists(id);
        // 校验字典类型有效
        checkDictTypeValid(dictType);
        // 校验字典数据的值的唯一性
        checkDictDataValueUnique(id, dictType, value);
    }

    public void checkDictDataExists(Long id) {
        if (id == null) {
            return;
        }
        SysDictItem sysDictItem = sysDictItemMapper.selectById(id);
        if (sysDictItem == null) {
            throw new ServiceException(ResultCode.DICT_DATA_NOT_EXISTS);
        }
    }

    public void checkDictTypeValid(String type) {
        SysDictItem dictType = sysDictItemMapper.getByDictType(type);
        if (dictType == null) {
            throw new ServiceException(ResultCode.DICT_TYPE_NOT_EXISTS);
        }
        if (!StatusEnum.ENABLE.getStatus().equals(dictType.getStatus())) {
            throw new ServiceException(ResultCode.DICT_TYPE_NOT_ENABLE);
        }
    }
    public void checkDictDataValueUnique(Long id, String dictType, String value) {
        SysDictItem sysDictItem = sysDictItemMapper.selectByDictTypeAndValue(dictType, value);
        if (sysDictItem == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的字典数据
        if (id == null) {
            throw new ServiceException(ResultCode.DICT_DATA_VALUE_DUPLICATE);
        }
        if (!sysDictItem.getDictItemId().equals(id)) {
            throw new ServiceException(ResultCode.DICT_DATA_VALUE_DUPLICATE);
        }
    }
    @Override
    public int updateDictItem(SysDictItemUpdateCmd sysDictItemUpdateCmd) {
        checkCreateOrUpdate(sysDictItemUpdateCmd.getDictItemId(), sysDictItemUpdateCmd.getValue(),sysDictItemUpdateCmd.getDictType());
        SysDictItem sysDictItem = SysDictItemConvert.INSTANCE.convert(sysDictItemUpdateCmd);
        return sysDictItemMapper.insert(sysDictItem);
    }

    @Override
    public int removeDictData(Long dictItemId) {
        checkDictDataExists(dictItemId);
        return sysDictItemMapper.deleteById(dictItemId);
    }

    @Override
    public IPage<SysDictItemDTO> pageDictItems(SysDictItemPageQry sysDictItemPageQry) {
        return SysDictItemConvert.INSTANCE.convertToDTO(sysDictItemMapper.selectPageDictItems(PageUtil.getPage(sysDictItemPageQry), sysDictItemPageQry));
    }

    @Override
    public SysDictItemDTO getDictItem(Long dictItemId) {
        return SysDictItemConvert.INSTANCE.convert(sysDictItemMapper.selectById(dictItemId));
    }

    @Override
    public List<SysDictItemDTO> listSimpleDictItems() {
        return SysDictItemConvert.INSTANCE.convertToDTO(sysDictItemMapper.selectListSimpleDictItems(StatusEnum.ENABLE.getStatus()));
    }

}
