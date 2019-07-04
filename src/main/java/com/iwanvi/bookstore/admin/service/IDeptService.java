package com.iwanvi.bookstore.admin.service;

import com.iwanvi.bookstore.admin.domain.Dept;
import com.iwanvi.bookstore.admin.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * @Author YDF
 * @Description 部门管理 服务层
 * @Date 2019/3/12 0012 17:33
 * @Version 1.0
 **/
public interface IDeptService {
	/**
	 * 查询部门管理数据
	 *
	 * @param dept 部门信息
	 * @return 部门信息集合
	 */
	public List<Dept> selectDeptList(Dept dept);
	
	/**
	 * 查询部门管理树
	 *
	 * @param dept 部门信息
	 * @return 所有部门信息
	 */
	public List<Map<String, Object>> selectDeptTree(Dept dept);
	
	/**
	 * 根据角色ID查询菜单
	 *
	 * @param role 角色对象
	 * @return 菜单列表
	 */
	public List<Map<String, Object>> roleDeptTreeData(Role role);
	
	/**
	 * 查询部门人数
	 *
	 * @param parentId 父部门ID
	 * @return 结果
	 */
	public int selectDeptCount(Long parentId);
	
	/**
	 * 查询部门是否存在用户
	 *
	 * @param deptId 部门ID
	 * @return 结果 true 存在 false 不存在
	 */
	public boolean checkDeptExistUser(Long deptId);
	
	/**
	 * 删除部门管理信息
	 *
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int deleteDeptById(Long deptId);
	
	/**
	 * 新增保存部门信息
	 *
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int insertDept(Dept dept);
	
	/**
	 * 修改保存部门信息
	 *
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int updateDept(Dept dept);
	
	/**
	 * 根据部门ID查询信息
	 *
	 * @param deptId 部门ID
	 * @return 部门信息
	 */
	public Dept selectDeptById(Long deptId);
	
	/**
	 * 校验部门名称是否唯一
	 *
	 * @param dept 部门信息
	 * @return 结果
	 */
	public String checkDeptNameUnique(Dept dept);
}
