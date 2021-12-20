package com.qinweizhao.system.module.authority.controller;


import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.authority.service.ISysDeptService;
import com.qinweizhao.system.module.authority.service.ISysPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/post")
public class SysPostController {
    @Resource
    ISysPostService sysPostService;

    @GetMapping("/list")
    public Result<Object> list() {
        return Result.success(sysPostService.list());
    }

}
