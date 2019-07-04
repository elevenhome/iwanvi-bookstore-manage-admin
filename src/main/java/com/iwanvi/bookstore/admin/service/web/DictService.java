package com.iwanvi.bookstore.admin.service.web;

import com.iwanvi.bookstore.admin.domain.DictData;
import com.iwanvi.bookstore.admin.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YDF
 * @Description html调用 thymeleaf 实现字典读取
 * @Date 2019/3/13 0013 13:40
 * @Version 1.0
 **/
@Service("dict")
public class DictService {
	@Autowired
	private IDictDataService dictDataService;
	
	/**
	 * 根据字典类型查询字典数据信息
	 *
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<DictData> getType(String dictType) {
		return dictDataService.selectDictDataByType(dictType);
	}
	
	/**
	 * 根据字典类型和字典键值查询字典数据信息
	 *
	 * @param dictType  字典类型
	 * @param dictValue 字典键值
	 * @return 字典标签
	 */
	public String getLabel(String dictType, String dictValue) {
		return dictDataService.selectDictLabel(dictType, dictValue);
	}
}
