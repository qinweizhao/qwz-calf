package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.command.SysPostSaveCmd;
import com.qinweizhao.api.system.dto.command.SysPostUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysPostPageQry;

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

    /**
     * 获取岗位分页
     *
     * @param sysPostPageQry sysPostPageQry
     * @return IPage<SysPostDTO>
     */
    IPage<SysPostDTO> pageSysPosts(SysPostPageQry sysPostPageQry);

    /**
     * 保存岗位
     *
     * @param sysPostSaveCmd sysPostSaveCmd
     * @return int
     */
    int savePost(SysPostSaveCmd sysPostSaveCmd);

    /**
     * 通过 Id 更新岗位
     *
     * @param sysPostUpdateCmd sysPostUpdateCmd
     * @return int
     */
    int updatePostById(SysPostUpdateCmd sysPostUpdateCmd);

    /**
     * 移除岗位
     *
     * @param postId postId
     * @return int
     */
    int removePostById(Long postId);

    /**
     * 获取岗位
     *
     * @param postId postId
     * @return SysPostDTO
     */
    SysPostDTO getPostById(Long postId);

    /**
     * 开启状态的岗位
     *
     * @return List<SysPostDTO>
     */
    List<SysPostDTO> listSimplePost();

}
