package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 用户不存在异常类
 * @Date 2019/3/12 0012 11:26
 * @Version 1.0
 **/
public class UserNotExistsException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public UserNotExistsException() {
		super("user.not.exists", null);
	}
}
