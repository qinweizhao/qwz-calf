package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.command.SysPostSaveCmd;
import com.qinweizhao.api.system.dto.command.SysPostUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysPostPageQry;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysPostConvert;
import com.qinweizhao.system.module.manage.mapper.SysPostMapper;
import com.qinweizhao.system.module.manage.service.ISysPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysPostServiceImpl implements ISysPostService {

    @Resource
    private SysPostMapper sysPostMapper;

    @Override
    public IPage<SysPostDTO> pageSysPosts(SysPostPageQry sysPostPageQry) {
        return SysPostConvert.INSTANCE.convertToDTO(sysPostMapper.selectPagePosts(PageUtil.getPage(sysPostPageQry), sysPostPageQry));
    }

    @Override
    public int savePost(SysPostSaveCmd sysPostSaveCmd) {
        return 0;
    }

    @Override
    public int updatePostById(SysPostUpdateCmd sysPostUpdateCmd) {
        return 0;
    }

    @Override
    public int removePostById(Long postId) {
        return 0;
    }

    @Override
    public SysPostDTO getPostById(Long postId) {
        return SysPostConvert.INSTANCE.convert(sysPostMapper.selectById(postId));
    }

    @Override
    public List<SysPostDTO> listSimplePost() {
        return SysPostConvert.INSTANCE.convertToDTO(sysPostMapper.selectList(null));

    }


}
