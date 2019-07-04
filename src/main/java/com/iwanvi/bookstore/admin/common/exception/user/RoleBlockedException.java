package com.iwanvi.bookstore.admin.common.exception.user;

/**
 * @Author YDF
 * @Description 角色锁定异常类
 * @Date 2019/3/12 0012 11:23
 * @Version 1.0
 **/
public class RoleBlockedException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public RoleBlockedException() {
		super("role.blocked", null);
	}
	
}
