package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 用户账号已被删除
 * @Date 2019/3/12 0012 11:26
 * @Version 1.0
 **/
public class UserDeleteException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public UserDeleteException() {
		super("user.password.delete", null);
	}
}
