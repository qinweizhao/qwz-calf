/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qinweizhao.common.log.util;

import cn.hutool.core.util.URLUtil;
import com.qinweizhao.common.log.SysLogDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * 系统日志工具类
 *
 * @author qinweizhao
 * @since 2021/12/31
 */
@UtilityClass
public class SysLogUtils {

	public SysLogDTO getSysLog() {
		HttpServletRequest request = ((ServletRequestAttributes) Objects
				.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
		SysLogDTO sysLog = new SysLogDTO();

		sysLog.setCreator(Objects.requireNonNull(getUsername()));
		sysLog.setUpdater(Objects.requireNonNull(getUsername()));
		// sysLog.setOperateType(LogTypeEnum.NORMAL.getType());
		sysLog.setUserIp(URLUtil.getPath(request.getRequestURI()));
		sysLog.setRequestMethod(request.getMethod());
		sysLog.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
		return sysLog;
	}



	/**
	 * 获取用户名称
	 * @return username
	 */
	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		return authentication.getName();
	}

}
