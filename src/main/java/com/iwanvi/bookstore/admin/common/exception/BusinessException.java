package com.iwanvi.bookstore.admin.common.exception;

/**
 * @Author YDF
 * @Description 业务异常
 * @Date 2019/3/12 0012 10:19
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	protected final String message;
	
	public BusinessException(String message) {
		this.message = message;
	}
	
	public BusinessException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
