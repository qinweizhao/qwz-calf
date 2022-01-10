package com.qinweizhao.system.api;

import cn.hutool.core.codec.Base64;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.common.core.constant.AuthConstants;
import com.qinweizhao.api.system.SysUserApi;
import com.qinweizhao.common.core.util.GuavaCacheUtils;
import com.qinweizhao.system.module.manage.entity.SysUser;
import com.qinweizhao.system.module.manage.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/12/13
 */
@Slf4j
@Service
public class SysUserApiImpl implements SysUserApi {

    @Resource
    ISysUserService sysUserService;

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Override
    public String getAuthorityByUserId(Long userId) {
        return sysUserService.getAuthorityByUserId(userId);
    }

    @Override
    public String getCaptcha() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String text = defaultKaptcha.createText();
        if (log.isDebugEnabled()) {
            log.debug("验证码为:" + text);
        }
        String key = AuthConstants.LOGIN_CODE_KEY + "_" + RandomStringUtils.random(5);
        GuavaCacheUtils.CACHE.put(key, text);
        BufferedImage image = defaultKaptcha.createImage(text);
        ImageIO.write(image, "jpg", outputStream);
        outputStream.flush();
        return AuthConstants.BASE64_PREFIX + Base64.encode(outputStream.toByteArray());
    }

    @Override
    public SysUserDTO getUserIdByUsername(String username) {
        SysUser sysUser = sysUserService.selectUserByUsername(username);
        SysUserDTO user = new SysUserDTO();
        BeanUtils.copyProperties(sysUser,user);
        return user;
    }
}
