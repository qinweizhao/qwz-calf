package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.api.system.dto.command.SysDeptSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDeptUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDeptListQry;
import com.qinweizhao.api.system.vo.SysDeptVO;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.system.module.manage.convert.SysDeptConvert;
import com.qinweizhao.system.module.manage.entity.SysDept;
import com.qinweizhao.system.module.manage.mapper.SysDeptMapper;
import com.qinweizhao.system.module.manage.service.ISysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysDeptServiceImpl  implements ISysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDeptDTO> listSimpleDepts() {
        return SysDeptConvert.INSTANCE.convertToDTO(sysDeptMapper.selectListSimpleDepts(StatusEnum.ENABLE.getStatus()));
    }

    /**
     * 通过用户名获取部门名称
     *
     * @param userId userId
     * @return String
     */
    @Override
    public String getDeptNameByUserId(Long userId) {
        return sysDeptMapper.selectDeptNameByUserId(userId);
    }

    @Override
    public List<SysDeptDTO> listDepts(SysDeptListQry sysDeptListQry) {
        return SysDeptConvert.INSTANCE.convertToDTO(sysDeptMapper.selectListDepts(sysDeptListQry));
    }

    @Override
    public int saveDept(SysDeptSaveCmd sysDeptSaveCmd) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(sysDeptSaveCmd);
        return sysDeptMapper.insert(sysDept);
    }

    @Override
    public int updateDeptById(SysDeptUpdateCmd sysDeptUpdateCmd) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(sysDeptUpdateCmd);
        return sysDeptMapper.updateById(sysDept);
    }

    @Override
    public int removeDeptById(Long deptId) {
        return sysDeptMapper.deleteById(deptId);
    }

    @Override
    public SysDeptDTO getDeptById(Long deptId) {
        return SysDeptConvert.INSTANCE.convert(sysDeptMapper.selectById(deptId));
    }
}
