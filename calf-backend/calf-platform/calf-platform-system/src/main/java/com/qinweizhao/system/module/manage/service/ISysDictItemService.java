package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysDictItemDTO;
import com.qinweizhao.api.system.dto.command.SysDictItemSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictItemUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDictItemPageQry;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface ISysDictItemService {

    int saveDictData(SysDictItemSaveCmd sysDictItemSaveCmd);

    int updateDictItem(SysDictItemUpdateCmd sysDictItemUpdateCmd);

    int removeDictData(Long dictItemId);

    IPage<SysDictItemDTO> pageDictItems(SysDictItemPageQry sysDictItemPageQry);

    SysDictItemDTO getDictItem(Long dictItemId);

    /**
     * 获取部分字典数据 dictType、value、label
     *
     * @return List<SysDictItemDTO>
     */
    List<SysDictItemDTO> listSimpleDictItems();


}
