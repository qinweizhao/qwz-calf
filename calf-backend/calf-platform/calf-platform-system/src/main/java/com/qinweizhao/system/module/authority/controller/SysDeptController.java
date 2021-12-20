package com.qinweizhao.system.module.authority.controller;


import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.authority.service.ISysDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController {

    @Resource
    ISysDeptService sysDeptService;

    @GetMapping("/list")
    public Result<Object> list() {
        return Result.success(sysDeptService.list());
    }


}
