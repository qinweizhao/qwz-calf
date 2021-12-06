package com.qinweizhao.calf.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.ISysPostService;
import com.qinweizhao.calf.dao.system.dataobject.SysPost;
import com.qinweizhao.calf.dao.system.mapper.SysPostMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

}
