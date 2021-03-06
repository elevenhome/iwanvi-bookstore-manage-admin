package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Log;
import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.BusinessType;
import com.iwanvi.bookstore.admin.common.page.TableDataInfo;
import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ExcelUtil;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.JobLog;
import com.iwanvi.bookstore.admin.service.IJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YDF
 * @Description 调度日志操作处理
 * @Date 2019/3/19 0019 16:34
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/jobLog")
public class JobLogController extends BaseController {
	private String prefix = "monitor/job";
	
	@Autowired
	private IJobLogService jobLogService;
	
	@RequiresPermissions("monitor:job:view")
	@GetMapping()
	public String jobLog() {
		return prefix + "/jobLog";
	}
	
	@RequiresPermissions("monitor:job:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(JobLog jobLog) {
		startPage();
		List<JobLog> list = jobLogService.selectJobLogList(jobLog);
		return getDataTable(list);
	}
	
	@Log(title = "调度日志", businessType = BusinessType.EXPORT)
	@RequiresPermissions("monitor:job:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(JobLog jobLog) {
		List<JobLog> list = jobLogService.selectJobLogList(jobLog);
		ExcelUtil<JobLog> util = new ExcelUtil<JobLog>(JobLog.class);
		return util.exportExcel(list, "调度日志");
	}
	
	@Log(title = "调度日志", businessType = BusinessType.DELETE)
	@RequiresPermissions("monitor:job:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(jobLogService.deleteJobLogByIds(ids));
	}
	
	@RequiresPermissions("monitor:job:detail")
	@GetMapping("/detail/{jobLogId}")
	public String detail(@PathVariable("jobLogId") Long jobLogId, ModelMap mmap) {
		mmap.put("name", "jobLog");
		mmap.put("jobLog", jobLogService.selectJobLogById(jobLogId));
		return prefix + "/detail";
	}
	
	@Log(title = "调度日志", businessType = BusinessType.CLEAN)
	@RequiresPermissions("monitor:job:remove")
	@PostMapping("/clean")
	@ResponseBody
	public AjaxResult clean() {
		jobLogService.cleanJobLog();
		return success();
	}
}
