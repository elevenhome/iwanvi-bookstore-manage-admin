package com.iwanvi.bookstore.admin.service;

import com.iwanvi.bookstore.admin.domain.book.PlatformBook;

import java.util.List;

/**
 * 平台书单 服务层
 * @author iwanvi
 * @date 2019-04-03
 */
public interface IPlatformBookService {
	/**
	 * 查询平台书单信息
	 *
	 * @param id 平台书单ID
	 * @return 平台书单信息
	 */
	public PlatformBook selectPlatformBookById(Integer id);
	/**
	 * 查询平台书单信息
	 *
	 * @param bookId 图书ID
	 * @return 平台书单信息
	 */
	public List<PlatformBook> selectPlatformBookByBookId(String bookId);
	
	/**
	 * 查询平台书单列表
	 *
	 * @param platformBook 平台书单信息
	 * @return 平台书单集合
	 */
	public List<PlatformBook> selectPlatformBookList(PlatformBook platformBook);
	
	/**
	 * 新增平台书单
	 *
	 * @param platformBook 平台书单信息
	 * @return 结果
	 */
	public int insertPlatformBook(PlatformBook platformBook);
	
	/**
	 * 修改平台书单
	 *
	 * @param platformBook 平台书单信息
	 * @return 结果
	 */
	public int updatePlatformBook(PlatformBook platformBook);

	/**
	 * 删除平台书单信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deletePlatformBookByIds(String ids);
	
}
