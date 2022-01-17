package com.qinweizhao.system.module.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.manage.entity.SysUserPost;
import com.qinweizhao.system.module.manage.mapper.SysUserPostMapper;
import com.qinweizhao.system.module.manage.service.ISysUserPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysUserPostServiceImpl implements ISysUserPostService {

    @Resource
    private SysUserPostMapper sysUserPostMapper;
    @Override
    public List<Long> listPostIdsByUserId(Long userId) {
        return sysUserPostMapper.selectPostIdsByUserId(userId);
    }
}
