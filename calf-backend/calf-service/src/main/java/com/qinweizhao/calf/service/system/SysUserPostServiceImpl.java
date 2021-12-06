package com.qinweizhao.calf.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.ISysUserPostService;
import com.qinweizhao.calf.dao.system.dataobject.SysUserPost;
import com.qinweizhao.calf.dao.system.mapper.SysUserPostMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements ISysUserPostService {

}
