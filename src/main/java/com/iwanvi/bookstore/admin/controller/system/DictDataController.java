package com.iwanvi.bookstore.admin.controller.system;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Log;
import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.BusinessType;
import com.iwanvi.bookstore.admin.common.page.TableDataInfo;
import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ExcelUtil;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.DictData;
import com.iwanvi.bookstore.admin.service.IDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YDF
 * @Description 数据字典信息
 * @Date 2019/3/13 0013 11:53
 * @Version 1.0
 **/
@Controller
@RequestMapping("/system/dict/data")
public class DictDataController extends BaseController {
	private String prefix = "system/dict/data";
	
	@Autowired
	private IDictDataService dictDataService;
	
	@RequiresPermissions("system:dict:view")
	@GetMapping()
	public String dictData() {
		return prefix + "/data";
	}
	
	@PostMapping("/list")
	@RequiresPermissions("system:dict:list")
	@ResponseBody
	public TableDataInfo list(DictData dictData) {
		startPage();
		List<DictData> list = dictDataService.selectDictDataList(dictData);
		return getDataTable(list);
	}
	
	@Log(title = "字典数据", businessType = BusinessType.EXPORT)
	@RequiresPermissions("system:dict:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(DictData dictData) {
		List<DictData> list = dictDataService.selectDictDataList(dictData);
		ExcelUtil<DictData> util = new ExcelUtil<DictData>(DictData.class);
		return util.exportExcel(list, "字典数据");
	}
	
	/**
	 * 新增字典类型
	 */
	@GetMapping("/add/{dictType}")
	public String add(@PathVariable("dictType") String dictType, ModelMap mmap) {
		mmap.put("dictType", dictType);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存字典类型
	 */
	@Log(title = "字典数据", businessType = BusinessType.INSERT)
	@RequiresPermissions("system:dict:add")
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DictData dict) {
		return toAjax(dictDataService.insertDictData(dict));
	}
	
	/**
	 * 修改字典类型
	 */
	@GetMapping("/edit/{dictCode}")
	public String edit(@PathVariable("dictCode") Long dictCode, ModelMap mmap) {
		mmap.put("dict", dictDataService.selectDictDataById(dictCode));
		return prefix + "/edit";
	}
	
	/**
	 * 修改保存字典类型
	 */
	@Log(title = "字典数据", businessType = BusinessType.UPDATE)
	@RequiresPermissions("system:dict:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DictData dict) {
		return toAjax(dictDataService.updateDictData(dict));
	}
	
	@Log(title = "字典数据", businessType = BusinessType.DELETE)
	@RequiresPermissions("system:dict:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(dictDataService.deleteDictDataByIds(ids));
	}
}
