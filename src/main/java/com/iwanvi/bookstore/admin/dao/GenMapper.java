package com.iwanvi.bookstore.admin.dao;

import com.iwanvi.bookstore.admin.domain.gen.ColumnInfo;
import com.iwanvi.bookstore.admin.domain.gen.TableInfo;

import java.util.List;

/**
 * @Author YDF
 * @Description 代码生成 数据层
 * @Date 2019/3/13 0013 14:45
 * @Version 1.0
 **/
public interface GenMapper {
	/**
	 * 查询ry数据库表信息
	 *
	 * @param tableInfo 表信息
	 * @return 数据库表列表
	 */
	public List<TableInfo> selectTableList(TableInfo tableInfo);
	
	/**
	 * 根据表名称查询信息
	 *
	 * @param tableName 表名称
	 * @return 表信息
	 */
	public TableInfo selectTableByName(String tableName);
	
	/**
	 * 根据表名称查询列信息
	 *
	 * @param tableName 表名称
	 * @return 列信息
	 */
	public List<ColumnInfo> selectTableColumnsByName(String tableName);
}
