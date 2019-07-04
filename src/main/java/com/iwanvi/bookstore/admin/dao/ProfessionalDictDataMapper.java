package com.iwanvi.bookstore.admin.dao;

import com.iwanvi.bookstore.admin.domain.book.ProfessionalDictData;

import java.util.List;

/**
 * 业务参数字典 数据层
 * @author iwanvi
 * @date 2019-04-03
 */
public interface ProfessionalDictDataMapper {
	/**
	 * 查询业务参数字典信息
	 *
	 * @param id 业务参数字典ID
	 * @return 业务参数字典信息
	 */
	public ProfessionalDictData selectProfessionalDictDataById(Integer id);
	/**
	 * 查询业务参数字典信息，根据书单编号
	 *
	 * @param bookListId 书单编号
	 * @return 业务参数字典信息
	 */
	public ProfessionalDictData selectProfessionalDictDataByBookListId(Integer bookListId);
	
	/**
	 * 查询业务参数字典列表
	 *
	 * @param professionalDictData 业务参数字典信息
	 * @return 业务参数字典集合
	 */
	public List<ProfessionalDictData> selectProfessionalDictDataList(ProfessionalDictData professionalDictData);
	
	/**
	 * 新增业务参数字典
	 *
	 * @param professionalDictData 业务参数字典信息
	 * @return 结果
	 */
	public int insertProfessionalDictData(ProfessionalDictData professionalDictData);
	
	/**
	 * 修改业务参数字典
	 *
	 * @param professionalDictData 业务参数字典信息
	 * @return 结果
	 */
	public int updateProfessionalDictData(ProfessionalDictData professionalDictData);
	
	/**
	 * 删除业务参数字典
	 *
	 * @param id 业务参数字典ID
	 * @return 结果
	 */
	public int deleteProfessionalDictDataById(Integer id);
	
	/**
	 * 批量删除业务参数字典
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteProfessionalDictDataByIds(String[] ids);
	
	/**
	 * 加载所有
	 */
	public List<ProfessionalDictData> selectAll();
}