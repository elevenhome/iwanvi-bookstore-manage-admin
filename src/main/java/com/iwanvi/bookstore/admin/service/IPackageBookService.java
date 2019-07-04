package com.iwanvi.bookstore.admin.service;

import com.iwanvi.bookstore.admin.domain.book.PackageBook;

import java.util.List;

/**
 * 套壳包书单 服务层
 * @author iwanvi
 * @date 2019-04-03
 */
public interface IPackageBookService {
	/**
	 * 查询套壳包书单信息
	 *
	 * @param id 套壳包书单ID
	 * @return 套壳包书单信息
	 */
	public PackageBook selectPackageBookById(Integer id);
	
	/**
	 * 查询套壳包书单信息
	 *
	 * @param bookId 图书ID
	 * @return 套壳包书单信息
	 */
	public List<PackageBook> selectPackageBookByBookId(String bookId);
	
	/**
	 * 查询套壳包书单列表
	 *
	 * @param packageBook 套壳包书单信息
	 * @return 套壳包书单集合
	 */
	public List<PackageBook> selectPackageBookList(PackageBook packageBook);
	
	/**
	 * 新增套壳包书单
	 *
	 * @param packageBook 套壳包书单信息
	 * @return 结果
	 */
	public int insertPackageBook(PackageBook packageBook);
	
	/**
	 * 修改套壳包书单
	 *
	 * @param packageBook 套壳包书单信息
	 * @return 结果
	 */
	public int updatePackageBook(PackageBook packageBook);

	/**
	 * 删除套壳包书单信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deletePackageBookByIds(String ids);
	
}
