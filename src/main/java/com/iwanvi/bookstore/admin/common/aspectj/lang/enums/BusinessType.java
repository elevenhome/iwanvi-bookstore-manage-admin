package com.iwanvi.bookstore.admin.common.aspectj.lang.enums;

/**
 * @Author YDF
 * @Description 业务操作类型
 * @Date 2019/3/12 0012 10:29
 * @Version 1.0
 **/
public enum BusinessType {
	/**
	 * 其它
	 */
	OTHER,
	
	/**
	 * 新增
	 */
	INSERT,
	
	/**
	 * 修改
	 */
	UPDATE,
	
	/**
	 * 删除
	 */
	DELETE,
	
	/**
	 * 授权
	 */
	GRANT,
	
	/**
	 * 导出
	 */
	EXPORT,
	
	/**
	 * 导入
	 */
	IMPORT,
	
	/**
	 * 强退
	 */
	FORCE,
	
	/**
	 * 生成代码
	 */
	GENCODE,
	
	/**
	 * 清空数据
	 */
	CLEAN,
}
