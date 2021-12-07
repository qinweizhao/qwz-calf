package com.qinweizhao.calf.service.system;


import cn.hutool.core.codec.Base64;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.qinweizhao.calf.api.system.SysUserService;
import com.qinweizhao.calf.base.Constants;
import com.qinweizhao.calf.base.util.GuavaCacheUtils;
import com.qinweizhao.calf.dao.system.dataobject.SysUser;
import com.qinweizhao.calf.dao.system.mapper.SysUserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Override
    public SysUser selectUserByUsername(String username) {
        return this.baseMapper.selectUserByUsername(username);
    }

    @Override
    public String getAuthorityByUserId(Long userId) {
        String authority = "";
        Set<String> roleSet = this.baseMapper.selectRolesByUserId(userId);
        if (!roleSet.isEmpty()) {
            String roles = roleSet.stream().map("ROLE_"::concat).collect(Collectors.joining(","));
            log.debug("当前用户拥有的角色有:" + roles);
            authority = authority.concat(",");
        }
        Set<String> permissionSet = this.baseMapper.selectPermissionsByUserId(userId);

        if (!permissionSet.isEmpty()) {
            String permission = String.join(",", permissionSet);
            log.debug("当前用户拥有的菜单权限有:" + permission);
            authority = authority.concat(permission);
            log.debug("当前用户拥有的菜单权限有:" + authority);
        }
        return authority;
    }

    /**
     * 获取验证码
     *
     * @return base64编码
     */
    @Override
    public String getCaptcha() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String text = defaultKaptcha.createText();
        if (log.isDebugEnabled()) {
            log.debug("验证码为:" + text);
        }
        String key = Constants.LOGIN_CODE_KEY + "_" + RandomStringUtils.random(5);
        GuavaCacheUtils.CACHE.put(key, text);
        BufferedImage image = defaultKaptcha.createImage(text);
        ImageIO.write(image, "jpg", outputStream);
        outputStream.flush();
        return Constants.BASE64_PREFIX + Base64.encode(outputStream.toByteArray());
    }
}
