package com.iwanvi.bookstore.admin.dao;

import com.iwanvi.bookstore.admin.domain.RoleDept;

import java.util.List;

/**
 * @Author YDF
 * @Description 角色与部门关联表 数据层
 * @Date 2019/3/12 0012 11:12
 * @Version 1.0
 **/
public interface RoleDeptMapper {
	/**
	 * 通过角色ID删除角色和部门关联
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	public int deleteRoleDeptByRoleId(Long roleId);
	
	/**
	 * 批量删除角色部门关联信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteRoleDept(Long[] ids);
	
	/**
	 * 查询部门使用数量
	 *
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int selectCountRoleDeptByDeptId(Long deptId);
	
	/**
	 * 批量新增角色部门信息
	 *
	 * @param roleDeptList 角色部门列表
	 * @return 结果
	 */
	public int batchRoleDept(List<RoleDept> roleDeptList);
}
