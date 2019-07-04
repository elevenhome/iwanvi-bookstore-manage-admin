package com.iwanvi.bookstore.admin.service.impl;

import com.iwanvi.bookstore.admin.common.constant.UserConstants;
import com.iwanvi.bookstore.admin.common.exception.BusinessException;
import com.iwanvi.bookstore.admin.common.support.Convert;
import com.iwanvi.bookstore.admin.common.util.ShiroUtils;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import com.iwanvi.bookstore.admin.dao.DictDataMapper;
import com.iwanvi.bookstore.admin.dao.DictTypeMapper;
import com.iwanvi.bookstore.admin.domain.DictType;
import com.iwanvi.bookstore.admin.service.IDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YDF
 * @Description 字典 业务层处理
 * @Date 2019/3/13 0013 11:53
 * @Version 1.0
 **/
@Service
public class DictTypeServiceImpl implements IDictTypeService {
	@Autowired
	private DictTypeMapper dictTypeMapper;
	
	@Autowired
	private DictDataMapper dictDataMapper;
	
	/**
	 * 根据条件分页查询字典类型
	 *
	 * @param dictType 字典类型信息
	 * @return 字典类型集合信息
	 */
	@Override
	public List<DictType> selectDictTypeList(DictType dictType) {
		return dictTypeMapper.selectDictTypeList(dictType);
	}
	
	/**
	 * 根据所有字典类型
	 *
	 * @return 字典类型集合信息
	 */
	@Override
	public List<DictType> selectDictTypeAll() {
		return dictTypeMapper.selectDictTypeAll();
	}
	
	/**
	 * 根据字典类型ID查询信息
	 *
	 * @param dictId 字典类型ID
	 * @return 字典类型
	 */
	@Override
	public DictType selectDictTypeById(Long dictId) {
		return dictTypeMapper.selectDictTypeById(dictId);
	}
	
	/**
	 * 通过字典ID删除字典信息
	 *
	 * @param dictId 字典ID
	 * @return 结果
	 */
	@Override
	public int deleteDictTypeById(Long dictId) {
		return dictTypeMapper.deleteDictTypeById(dictId);
	}
	
	/**
	 * 批量删除字典类型
	 *
	 * @param ids 需要删除的数据
	 * @return 结果
	 */
	@Override
	public int deleteDictTypeByIds(String ids) throws BusinessException {
		Long[] dictIds = Convert.toLongArray(ids);
		for (Long dictId : dictIds) {
			DictType dictType = selectDictTypeById(dictId);
			if (dictDataMapper.countDictDataByType(dictType.getDictType()) > 0) {
				throw new BusinessException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
			}
		}
		
		return dictTypeMapper.deleteDictTypeByIds(dictIds);
	}
	
	/**
	 * 新增保存字典类型信息
	 *
	 * @param dictType 字典类型信息
	 * @return 结果
	 */
	@Override
	public int insertDictType(DictType dictType) {
		dictType.setCreateBy(ShiroUtils.getLoginName());
		return dictTypeMapper.insertDictType(dictType);
	}
	
	/**
	 * 修改保存字典类型信息
	 *
	 * @param dictType 字典类型信息
	 * @return 结果
	 */
	@Override
	public int updateDictType(DictType dictType) {
		dictType.setUpdateBy(ShiroUtils.getLoginName());
		DictType oldDict = dictTypeMapper.selectDictTypeById(dictType.getDictId());
		dictDataMapper.updateDictDataType(oldDict.getDictType(), dictType.getDictType());
		return dictTypeMapper.updateDictType(dictType);
	}
	
	/**
	 * 校验字典类型称是否唯一
	 *
	 * @param dict 字典类型
	 * @return 结果
	 */
	@Override
	public String checkDictTypeUnique(DictType dict) {
		Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
		DictType dictType = dictTypeMapper.checkDictTypeUnique(dict.getDictType());
		if (StringUtils.isNotNull(dictType) && dictType.getDictId().longValue() != dictId.longValue()) {
			return UserConstants.DICT_TYPE_NOT_UNIQUE;
		}
		return UserConstants.DICT_TYPE_UNIQUE;
	}
}
