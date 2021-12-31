package com.qinweizhao.common.core.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author qinweizhao
 * @since 2021/11/18
 */
public class BaseController {


    public String getCurrentLoginUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.valueOf(authentication.getPrincipal()
        );
    }
}
