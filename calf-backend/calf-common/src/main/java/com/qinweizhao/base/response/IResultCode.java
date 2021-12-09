package com.qinweizhao.base.response;

/**
 * 返回码接口
 * @author qinweizhao
 * @since 2021/9/25
 */
public interface IResultCode {

	/**
	 * 返回码
	 *
	 * @return int
	 */
	int getCode();

	/**
	 * 返回消息
	 *
	 * @return String
	 */
	String getMsg();
}
