package com.qinweizhao.base.util;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/9/27
 */
public class IoUtils {

    private static final Logger log = LoggerFactory.getLogger(IoUtils.class);

    private IoUtils() {

    }

    public static JSONObject parseRequestToJsonObject(HttpServletRequest request) {
        try (ServletInputStream inputStream = request.getInputStream()) {
            String s = IoUtil.read(inputStream).toString();
            log.info("登录信息:{}", s);
            return JSON.parseObject(s);
        } catch (IOException e) {
            throw new JSONException("can not cast to JSONObject.", e);
        }
    }
}
