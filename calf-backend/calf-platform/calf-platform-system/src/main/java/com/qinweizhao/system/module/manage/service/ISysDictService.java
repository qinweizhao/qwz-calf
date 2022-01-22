package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysDictDTO;
import com.qinweizhao.api.system.dto.command.SysDictSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDictPageQry;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
public interface ISysDictService {

    /**
     * 保存字典
     *
     * @param sysDictSaveCmd sysDictSaveCmd
     * @return int
     */
    int saveDictType(SysDictSaveCmd sysDictSaveCmd);

    /**
     * 修改字典
     *
     * @param sysDictUpdateCmd sysDictUpdateCmd
     * @return int
     */
    int updateDictType(SysDictUpdateCmd sysDictUpdateCmd);

    /**
     * 删除字典
     *
     * @param dictId dictId
     * @return int
     */
    int removeDict(Long dictId);

    /**
     * 获取字典
     *
     * @param dictId dictId
     * @return SysDictDTO
     */
    SysDictDTO getDict(Long dictId);

    /**
     * 获取字典列表(开启状态）
     *
     * @return List<SysDictDTO>
     */
    List<SysDictDTO> listSimpleDicts();

    /**
     * 获取字典分类数据
     *
     * @param sysDictPageQry sysDictPageQry
     * @return IPage<SysDictDTO>
     */
    IPage<SysDictDTO> pageDicts(SysDictPageQry sysDictPageQry);
}
