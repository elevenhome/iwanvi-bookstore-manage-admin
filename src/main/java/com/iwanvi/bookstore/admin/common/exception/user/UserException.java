package com.iwanvi.bookstore.admin.common.exception.user;

import com.iwanvi.bookstore.admin.common.exception.BaseException;

/**
 * @Author YDF
 * @Description 用户信息异常类
 * @Date 2019/3/12 0012 11:24
 * @Version 1.0
 **/
public class UserException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public UserException(String code, Object[] args) {
		super("user", code, args, null);
	}
}
