package com.qinweizhao.system.module.tool.controller;


import com.qinweizhao.common.util.DataType;
import com.qinweizhao.common.util.ParamType;
import com.qinweizhao.system.module.manage.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021/10/13
 */
@Api(tags = "用户管理s")
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {


    /**
     * 多个参数用  @ApiImplicitParams
     *
     * @param current 当前页
     * @param size    大小
     * @return list
     */
    @ApiOperation(value = "查询用户", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = DataType.INT, paramType = ParamType.QUERY),
            @ApiImplicitParam(name = "size", value = "大小", dataType = DataType.INT, paramType = "path")
    })
    @GetMapping("/list")
    public List<SysUser> list(String current, String size) {
        System.out.println(current + "" + size);
        return new ArrayList<>();
    }


}
