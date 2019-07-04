package com.iwanvi.bookstore.admin.service.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * @Author YDF
 * @Description js调用 thymeleaf 实现按钮权限可见性
 * @Date 2019/3/12 0012 19:17
 * @Version 1.0
 **/
@Service("permission")
public class PermissionService {
	public String hasPermi(String permission) {
		return isPermittedOperator(permission) ? "" : "hidden";
	}
	
	private boolean isPermittedOperator(String permission) {
		return SecurityUtils.getSubject().isPermitted(permission);
	}
	
}
