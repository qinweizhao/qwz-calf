package com.qinweizhao.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.common.request.Search;
import com.qinweizhao.system.entity.SysUser;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysUserService extends IService<SysUser> {

    Object listPage(Search search, SysUser sysUser);

    boolean status(String ids, String status);
}
