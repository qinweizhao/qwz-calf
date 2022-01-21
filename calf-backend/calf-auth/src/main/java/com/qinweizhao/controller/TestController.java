package com.qinweizhao.controller;

import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.common.core.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinweizhao
 * @since 2022/1/21
 */
@Api("test")
@RequestMapping("/test")
@RestController
public class TestController extends BaseController {


    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/info")
    @ApiOperation("测试信息")
    public SysUserDTO info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SysUserDTO sysUserDTO = (SysUserDTO) authentication.getPrincipal();
        log.info("sysUserDTO:{}", sysUserDTO);
        return sysUserDTO;
    }


}
