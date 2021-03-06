package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Log;
import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.BusinessType;
import com.iwanvi.bookstore.admin.common.page.TableDataInfo;
import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ExcelUtil;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.Job;
import com.iwanvi.bookstore.admin.service.IJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YDF
 * @Description 调度任务信息操作处理
 * @Date 2019/3/19 0019 16:35
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/job")
public class JobController extends BaseController {
	private String prefix = "monitor/job";
	
	@Autowired
	private IJobService jobService;
	
	@RequiresPermissions("monitor:job:view")
	@GetMapping()
	public String job() {
		return prefix + "/job";
	}
	
	@RequiresPermissions("monitor:job:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Job job) {
		startPage();
		List<Job> list = jobService.selectJobList(job);
		return getDataTable(list);
	}
	
	@Log(title = "定时任务", businessType = BusinessType.EXPORT)
	@RequiresPermissions("monitor:job:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Job job) {
		List<Job> list = jobService.selectJobList(job);
		ExcelUtil<Job> util = new ExcelUtil<Job>(Job.class);
		return util.exportExcel(list, "定时任务");
	}
	
	@Log(title = "定时任务", businessType = BusinessType.DELETE)
	@RequiresPermissions("monitor:job:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		try {
			jobService.deleteJobByIds(ids);
			return success();
		} catch (Exception e) {
			e.printStackTrace();
			return error(e.getMessage());
		}
	}
	
	@RequiresPermissions("monitor:job:detail")
	@GetMapping("/detail/{jobId}")
	public String detail(@PathVariable("jobId") Long jobId, ModelMap mmap) {
		mmap.put("name", "job");
		mmap.put("job", jobService.selectJobById(jobId));
		return prefix + "/detail";
	}
	
	/**
	 * 任务调度状态修改
	 */
	@Log(title = "定时任务", businessType = BusinessType.UPDATE)
	@RequiresPermissions("monitor:job:changeStatus")
	@PostMapping("/changeStatus")
	@ResponseBody
	public AjaxResult changeStatus(Job job) {
		return toAjax(jobService.changeStatus(job));
	}
	
	/**
	 * 任务调度立即执行一次
	 */
	@Log(title = "定时任务", businessType = BusinessType.UPDATE)
	@RequiresPermissions("monitor:job:changeStatus")
	@PostMapping("/run")
	@ResponseBody
	public AjaxResult run(Job job) {
		return toAjax(jobService.run(job));
	}
	
	/**
	 * 新增调度
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存调度
	 */
	@Log(title = "定时任务", businessType = BusinessType.INSERT)
	@RequiresPermissions("monitor:job:add")
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Job job) {
		return toAjax(jobService.insertJobCron(job));
	}
	
	/**
	 * 修改调度
	 */
	@GetMapping("/edit/{jobId}")
	public String edit(@PathVariable("jobId") Long jobId, ModelMap mmap) {
		mmap.put("job", jobService.selectJobById(jobId));
		return prefix + "/edit";
	}
	
	/**
	 * 修改保存调度
	 */
	@Log(title = "定时任务", businessType = BusinessType.UPDATE)
	@RequiresPermissions("monitor:job:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Job job) {
		return toAjax(jobService.updateJobCron(job));
	}
	
	/**
	 * 校验cron表达式是否有效
	 */
	@PostMapping("/checkCronExpressionIsValid")
	@ResponseBody
	public boolean checkCronExpressionIsValid(Job job) {
		return jobService.checkCronExpressionIsValid(job.getCronExpression());
	}
}
