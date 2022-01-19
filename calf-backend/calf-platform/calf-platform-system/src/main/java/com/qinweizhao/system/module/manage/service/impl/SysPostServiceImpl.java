package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.command.SysPostSaveCmd;
import com.qinweizhao.api.system.dto.command.SysPostUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysPostPageQry;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysPostConvert;
import com.qinweizhao.system.module.manage.entity.SysPost;
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
        // 校验正确性
        this.checkSaveOrUpdate(null, sysPostSaveCmd.getName(), sysPostSaveCmd.getCode());
        SysPost sysPost = SysPostConvert.INSTANCE.convert(sysPostSaveCmd);
        return sysPostMapper.insert(sysPost);
    }

    /**
     * 校验正确性
     *
     *
     * @param postId postId
     * @param name   name
     * @param code   code
     */
    private void checkSaveOrUpdate(Long postId, String name, String code) {
        // 校验自己存在
        checkPostExists(postId);
        // 校验岗位名的唯一性
        checkNameUnique(postId, name);
        // 校验岗位编码的唯一性
        checkCodeUnique(postId, code);
    }


    private void checkPostExists(Long postId) {
        if (postId == null) {
            return;
        }
        SysPost post = sysPostMapper.selectById(postId);
        if (post == null) {
            throw new ServiceException(ResultCode.POST_NOT_FOUND);
        }
    }

    private void checkNameUnique(Long postId, String name) {
        SysPost post = sysPostMapper.selectPostByname(name);
        if (post == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的岗位
        if (postId == null) {
            throw new ServiceException(ResultCode.POST_NAME_DUPLICATE);
        }
        if (!post.getPostId().equals(postId)) {
            throw new ServiceException(ResultCode.POST_NAME_DUPLICATE);
        }
    }

    private void checkCodeUnique(Long id, String code) {
        SysPost post = sysPostMapper.selectPostBycode(code);
        if (post == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的岗位
        if (id == null) {
            throw new ServiceException(ResultCode.POST_CODE_DUPLICATE);
        }
        if (!post.getPostId().equals(id)) {
            throw new ServiceException(ResultCode.POST_CODE_DUPLICATE);
        }
    }

    @Override
    public int updatePostById(SysPostUpdateCmd sysPostUpdateCmd) {
        // 校验正确性
        this.checkSaveOrUpdate(sysPostUpdateCmd.getPostId(), sysPostUpdateCmd.getName(), sysPostUpdateCmd.getCode());
        // 更新岗位
        SysPost sysPost = SysPostConvert.INSTANCE.convert(sysPostUpdateCmd);
        return sysPostMapper.updateById(sysPost);
    }

    @Override
    public int removePostById(Long postId) {
        // 校验是否存在
        this.checkPostExists(postId);
        // 删除部门
        return sysPostMapper.deleteById(postId);
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
