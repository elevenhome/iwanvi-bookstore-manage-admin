package com.iwanvi.bookstore.admin.service;

import com.iwanvi.bookstore.admin.domain.book.ProfessionalBook;

import java.util.List;

/**
 * 业务书单 服务层
 * @author iwanvi
 * @date 2019-04-03
 */
public interface IProfessionalBookService {
	/**
	 * 查询业务书单信息
	 *
	 * @param id 业务书单ID
	 * @return 业务书单信息
	 */
	public ProfessionalBook selectProfessionalBookById(Integer id);
	
	/**
	 * 查询业务书单信息
	 *
	 * @param bookId 图书ID
	 * @return 业务书单信息
	 */
	public List<ProfessionalBook> selectProfessionalBookByBookId(String bookId);
	
	/**
	 * 查询业务书单列表
	 *
	 * @param professionalBook 业务书单信息
	 * @return 业务书单集合
	 */
	public List<ProfessionalBook> selectProfessionalBookList(ProfessionalBook professionalBook);
	
	/**
	 * 查询业务书单列表
	 *
	 * @param professionalBook 业务书单信息
	 * @return 业务书单集合
	 */
	public List<ProfessionalBook> selectList(ProfessionalBook professionalBook);
	
	/**
	 * 新增业务书单
	 *
	 * @param professionalBook 业务书单信息
	 * @return 结果
	 */
	public int insertProfessionalBook(ProfessionalBook professionalBook);
	
	/**
	 * 修改业务书单
	 *
	 * @param professionalBook 业务书单信息
	 * @return 结果
	 */
	public int updateProfessionalBook(ProfessionalBook professionalBook);

	/**
	 * 删除业务书单信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteProfessionalBookByIds(String ids);
	
}
