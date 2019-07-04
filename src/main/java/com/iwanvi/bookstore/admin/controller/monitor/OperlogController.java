package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Log;
import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.BusinessType;
import com.iwanvi.bookstore.admin.common.page.TableDataInfo;
import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ExcelUtil;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.OperLog;
import com.iwanvi.bookstore.admin.service.IOperLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YDF
 * @Description 操作日志记录
 * @Date 2019/3/13 0013 14:20
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/operlog")
public class OperlogController extends BaseController {
	private String prefix = "monitor/operlog";
	
	@Autowired
	private IOperLogService operLogService;
	
	@RequiresPermissions("monitor:operlog:view")
	@GetMapping()
	public String operlog() {
		return prefix + "/operlog";
	}
	
	@RequiresPermissions("monitor:operlog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OperLog operLog) {
		startPage();
		List<OperLog> list = operLogService.selectOperLogList(operLog);
		return getDataTable(list);
	}
	
	@Log(title = "操作日志", businessType = BusinessType.EXPORT)
	@RequiresPermissions("monitor:operlog:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(OperLog operLog) {
		List<OperLog> list = operLogService.selectOperLogList(operLog);
		ExcelUtil<OperLog> util = new ExcelUtil<OperLog>(OperLog.class);
		return util.exportExcel(list, "操作日志");
	}
	
	@RequiresPermissions("monitor:operlog:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(operLogService.deleteOperLogByIds(ids));
	}
	
	@RequiresPermissions("monitor:operlog:detail")
	@GetMapping("/detail/{operId}")
	public String detail(@PathVariable("operId") Long operId, ModelMap mmap) {
		mmap.put("operLog", operLogService.selectOperLogById(operId));
		return prefix + "/detail";
	}
	
	@Log(title = "操作日志", businessType = BusinessType.CLEAN)
	@RequiresPermissions("monitor:operlog:remove")
	@PostMapping("/clean")
	@ResponseBody
	public AjaxResult clean() {
		operLogService.cleanOperLog();
		return success();
	}
}
