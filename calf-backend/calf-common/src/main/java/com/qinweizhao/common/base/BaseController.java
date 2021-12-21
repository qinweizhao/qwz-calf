package com.qinweizhao.common.base;

import cn.hutool.core.date.DateUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.sound.midi.Soundbank;
import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.util.Date;

/**
 * @author qinweizhao
 * @since 2021/11/18
 */
public class BaseController {


    public String getCurrentLoginUsername( ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.valueOf(authentication.getPrincipal()
        );
    }
}
