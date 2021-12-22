package com.qinweizhao.system.module.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.system.entity.SysNotice;
import com.qinweizhao.system.module.system.mapper.SysNoticeMapper;
import com.qinweizhao.system.module.system.service.ISysNoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {



}
