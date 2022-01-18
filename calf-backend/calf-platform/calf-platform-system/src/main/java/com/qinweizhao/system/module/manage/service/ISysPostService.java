package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.command.SysPostSaveCmd;
import com.qinweizhao.api.system.dto.command.SysPostUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysPostPageQry;
import com.qinweizhao.api.system.vo.SysPostRespVO;
import com.qinweizhao.system.module.manage.entity.SysPost;

import java.util.List;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysPostService {

    IPage<SysPostDTO> pageSysPosts(SysPostPageQry sysPostPageQry);

    int savePost(SysPostSaveCmd sysPostSaveCmd);

    int updatePostById(SysPostUpdateCmd sysPostUpdateCmd);

    int removePostById(Long postId);

    SysPostDTO getPostById(Long postId);

    List<SysPostDTO> listSimplePost();

}
