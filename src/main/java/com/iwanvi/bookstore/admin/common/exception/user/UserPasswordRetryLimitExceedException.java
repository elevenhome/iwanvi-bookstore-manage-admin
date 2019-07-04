package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 用户错误最大次数异常类
 * @Date 2019/3/12 0012 11:23
 * @Version 1.0
 **/
public class UserPasswordRetryLimitExceedException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public UserPasswordRetryLimitExceedException(int retryLimitCount) {
		super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
	}
}
