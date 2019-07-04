package com.iwanvi.bookstore.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iwanvi.bookstore.admin.dao.ProfessionalDictDataMapper;
import com.iwanvi.bookstore.admin.domain.book.ProfessionalDictData;
import com.iwanvi.bookstore.admin.service.IProfessionalDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iwanvi.bookstore.admin.common.support.Convert;

/**
 * 业务参数字典 服务层实现
 * @author iwanvi
 * @date 2019-04-03
 */
@Service
public class ProfessionalDictDataServiceImpl implements IProfessionalDictDataService {
	@Autowired
	private ProfessionalDictDataMapper professionalDictDataMapper;

	/**
	 * 查询业务参数字典信息
	 *
	 * @param id 业务参数字典ID
	 * @return 业务参数字典信息
	 */
	@Override
	public ProfessionalDictData selectProfessionalDictDataById(Integer id) {
		return professionalDictDataMapper.selectProfessionalDictDataById(id);
	}
	/**
	 * 查询业务参数字典信息，根据书单编号
	 *
	 * @param bookListId 书单编号
	 * @return 业务参数字典信息
	 */
	@Override
	public ProfessionalDictData selectProfessionalDictDataByBookListId(Integer bookListId){
		return professionalDictDataMapper.selectProfessionalDictDataByBookListId(bookListId);
	}
	
	/**
	 * 查询业务参数字典列表
	 *
	 * @param professionalDictData 业务参数字典信息
	 * @return 业务参数字典集合
	 */
	@Override
	public List<ProfessionalDictData> selectProfessionalDictDataList(ProfessionalDictData professionalDictData) {
		return professionalDictDataMapper.selectProfessionalDictDataList(professionalDictData);
	}
	
	/**
	 * 新增业务参数字典
	 *
	 * @param professionalDictData 业务参数字典信息
	 * @return 结果
	 */
	@Override
	public int insertProfessionalDictData(ProfessionalDictData professionalDictData) {
		return professionalDictDataMapper.insertProfessionalDictData(professionalDictData);
	}
	
	/**
	 * 修改业务参数字典
	 *
	 * @param professionalDictData 业务参数字典信息
	 * @return 结果
	 */
	@Override
	public int updateProfessionalDictData(ProfessionalDictData professionalDictData) {
		return professionalDictDataMapper.updateProfessionalDictData(professionalDictData);
	}

	/**
	 * 删除业务参数字典
	 *
	 * @param id 业务参数字典ID
	 * @return 结果
	 */
	@Override
	public int deleteProfessionalDictDataById(Integer id) {
		return professionalDictDataMapper.deleteProfessionalDictDataById(id);
	}

	/**
	 * 删除业务参数字典对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteProfessionalDictDataByIds(String ids) {
		return professionalDictDataMapper.deleteProfessionalDictDataByIds(Convert.toStrArray(ids));
	}
	
	/**
	 * 加载所有渠道列表树
	 */
	@Override
	public List<Map<String, Object>> treeData() {
		List<ProfessionalDictData> dataList = professionalDictDataMapper.selectAll();
		return getTrees(dataList);
	}
	
	/**
	 * 对象转树列表
	 * @param dataList     渠道列表
	 * @return
	 */
	public List<Map<String, Object>> getTrees(List<ProfessionalDictData> dataList) {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		for (ProfessionalDictData data : dataList) {
			//状态：1正常，树只显示有效
			if (data.getChannelStatus() == 1){
				Map<String, Object> deptMap = new HashMap<String, Object>();
				deptMap.put("id", data.getId());
				deptMap.put("pId", data.getParentId());
				//树名称显示渠道名
				//deptMap.put("name", data.getChannel());
				//树名称显示渠道编号
				deptMap.put("name", data.getBookListId());
				deptMap.put("bookListId", data.getBookListId());
				deptMap.put("checked", false);
				trees.add(deptMap);
			}
		}
		return trees;
	}
}
