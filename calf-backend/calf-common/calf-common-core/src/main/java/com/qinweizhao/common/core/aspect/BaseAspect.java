package com.qinweizhao.common.core.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.aspectj.lang.JoinPoint;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 切面基础类
 * @author qinweizhao
 * @since 2021/9/27
 */
public abstract class BaseAspect {

	/**
	 * 获取切面方法上包含的指定注解
	 *
	 * @param joinPoint joinPoint
	 * @param annotationClass annotationClass
	 * @param <T> t
	 * @return Annotation
	 */
	public <T extends Annotation> T getAnnotation(JoinPoint joinPoint, Class<T> annotationClass) {
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Method[] methods = joinPoint.getSignature().getDeclaringType().getMethods();
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				if (m.getParameterTypes().length == arguments.length) {
					return m.getAnnotation(annotationClass);
				}
			}
		}
		return null;
	}

	/**
	 * 默认key策略
	 *
	 * @param targetName targetName
	 * @param methodName methodName
	 * @param arguments arguments
	 * @return String
	 */
	public String getCacheKey(String key, String targetName, String methodName,
	                          Object[] arguments) {
		StringBuilder sb = new StringBuilder();
		if (key != null && key.length() > 0) {
			sb.append(key);
		} else {
			sb.append(targetName).append(".").append(methodName);
		}
		if (arguments != null && (arguments.length != 0)) {
			sb.append("#").append(JSON.toJSONString(arguments));
		}
		return sb.toString().replace("[", "").replace("\"", "").replace("]", "").replace("com.gofun.", "");
	}

	/**
	 * 获取key
	 * 根据condition
	 *
	 * @param key key
	 * @param condition condition
	 * @param arguments arguments
	 * @return String
	 */
	public String getCacheKey(String key, String condition, Object[] arguments) {
		StringBuilder sb = new StringBuilder();
		sb.append(key);
		String argJson = JSON.toJSONString(arguments);
		String[] params = null;
		if (condition != null && condition.trim().startsWith("#")) {
			condition = condition.trim();
			params = condition.split(",");
			for (String param : params) {
				param = param.replace("#", "");
				JSONObject val = (JSONObject) JSONPath.read(condition, param);
			}
		}
		return sb.toString();
	}
}
