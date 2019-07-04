package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 验证码错误异常类
 * @Date 2019/3/12 0012 17:33
 * @Version 1.0
 **/
public class CaptchaException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public CaptchaException() {
		super("user.jcaptcha.error", null);
	}
}
