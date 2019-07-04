package com.iwanvi.bookstore.admin.dao;

import com.iwanvi.bookstore.admin.domain.book.VersionBook;

import java.util.List;

/**
 * 版本书单 数据层
 * @author iwanvi
 * @date 2019-04-03
 */
public interface VersionBookMapper {
	/**
	 * 查询版本书单信息
	 *
	 * @param id 版本书单ID
	 * @return 版本书单信息
	 */
	public VersionBook selectVersionBookById(Integer id);
	
	/**
	 * 查询版本书单列表
	 *
	 * @param versionBook 版本书单信息
	 * @return 版本书单集合
	 */
	public List<VersionBook> selectVersionBookList(VersionBook versionBook);
	
	/**
	 * 新增版本书单
	 *
	 * @param versionBook 版本书单信息
	 * @return 结果
	 */
	public int insertVersionBook(VersionBook versionBook);
	
	/**
	 * 修改版本书单
	 *
	 * @param versionBook 版本书单信息
	 * @return 结果
	 */
	public int updateVersionBook(VersionBook versionBook);
	
	/**
	 * 删除版本书单
	 *
	 * @param id 版本书单ID
	 * @return 结果
	 */
	public int deleteVersionBookById(Integer id);
	
	/**
	 * 批量删除版本书单
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteVersionBookByIds(String[] ids);

	public List<VersionBook> selectVersionBookByBookId(String bookId);
}