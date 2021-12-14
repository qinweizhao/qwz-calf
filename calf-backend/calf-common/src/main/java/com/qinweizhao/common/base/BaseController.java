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

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtil.parseLocalDateTime(text, "yyyy-MM-dd HH:mm:ss"));
            }
        });
    }


    public String getCurrentLoginUsername( ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.valueOf(authentication.getPrincipal()
        );
    }
}
