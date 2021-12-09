package com.qinweizhao.common.response;

/**
 * 返回码接口
 *
 * @author qinweizhao
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
