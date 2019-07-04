package com.iwanvi.bookstore.admin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author YDF
 * @Description 角色和菜单关联 sys_role_menu
 * @Date 2019/3/12 0012 13:57
 * @Version 1.0
 **/
public class RoleMenu {
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	/**
	 * 菜单ID
	 */
	private Long menuId;
	
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	public Long getMenuId() {
		return menuId;
	}
	
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("roleId", getRoleId())
				.append("menuId", getMenuId())
				.toString();
	}
}
