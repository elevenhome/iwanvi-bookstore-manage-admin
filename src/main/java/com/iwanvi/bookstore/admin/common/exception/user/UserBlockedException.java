package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 用户锁定异常类
 * @Date 2019/3/12 0012 11:26
 * @Version 1.0
 **/
public class UserBlockedException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public UserBlockedException() {
		super("user.blocked", null);
	}
}
