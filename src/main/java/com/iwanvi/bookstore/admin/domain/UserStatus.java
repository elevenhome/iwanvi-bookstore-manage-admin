package com.iwanvi.bookstore.admin.domain;

/**
 * @Author YDF
 * @Description 用户状态
 * @Date 2019/3/12 0012 13:57
 * @Version 1.0
 **/
public enum UserStatus {
	OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");
	
	private final String code;
	private final String info;
	
	UserStatus(String code, String info) {
		this.code = code;
		this.info = info;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getInfo() {
		return info;
	}
}
