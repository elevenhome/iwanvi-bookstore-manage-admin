package com.iwanvi.bookstore.admin.common.exception;

/**
 * @Author YDF
 * @Description 计划策略异常
 * @Date 2019/3/19 0019 16:48
 * @Version 1.0
 **/
public class TaskException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Code code;
	
	public TaskException(String msg, Code code) {
		this(msg, code, null);
	}
	
	public TaskException(String msg, Code code, Exception nestedEx) {
		super(msg, nestedEx);
		this.code = code;
	}
	
	public Code getCode() {
		return code;
	}
	
	public enum Code {
		TASK_EXISTS, NO_TASK_EXISTS, TASK_ALREADY_STARTED, UNKNOWN, CONFIG_ERROR, TASK_NODE_NOT_AVAILABLE
	}
}