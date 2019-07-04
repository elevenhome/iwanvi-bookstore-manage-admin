package com.iwanvi.bookstore.admin.service;

import com.iwanvi.bookstore.admin.domain.book.ProfessionalDictData;

import java.util.List;
import java.util.Map;

/**
 * 业务参数字典 服务层
 * @author iwanvi
 * @date 2019-04-03
 */
public interface IProfessionalDictDataService {
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
	 * 删除业务参数字典信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteProfessionalDictDataByIds(String ids);
	
	/**
	 * 加载所有列表树
	 * @return 结果
	 */
	public List<Map<String, Object>> treeData();
}
