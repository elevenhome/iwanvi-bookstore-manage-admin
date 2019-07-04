package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 用户密码不正确或不符合规范异常类
 * @Date 2019/3/12 0012 11:26
 * @Version 1.0
 **/
public class UserPasswordNotMatchException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public UserPasswordNotMatchException() {
		super("user.password.not.match", null);
	}
}
