package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 用户错误记数异常类
 * @Date 2019/3/12 0012 11:26
 * @Version 1.0
 **/
public class UserPasswordRetryLimitCountException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public UserPasswordRetryLimitCountException(int retryLimitCount) {
		super("user.password.retry.limit.count", new Object[]{retryLimitCount});
	}
}
