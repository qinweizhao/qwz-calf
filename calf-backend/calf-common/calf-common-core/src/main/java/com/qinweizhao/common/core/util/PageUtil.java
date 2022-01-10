package com.qinweizhao.common.core.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.request.Search;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
public class PageUtil {


	public static <T> Page<T> getPage() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		assert servletRequestAttributes != null;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		int current = ServletRequestUtils.getIntParameter(request, "current", 1);
		int size = ServletRequestUtils.getIntParameter(request, "size", 10);
		return new Page<>(current, size);
	}
}
