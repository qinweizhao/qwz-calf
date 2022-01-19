package com.qinweizhao.system.module.manage.service;

import java.util.List;

/**
 * <p>
 * 用户与岗位关联表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysUserPostService {


    List<Long> listPostIdsByUserId(Long userId);
}
