package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Log;
import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.BusinessType;
import com.iwanvi.bookstore.admin.common.page.TableDataInfo;
import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ExcelUtil;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.Logininfor;
import com.iwanvi.bookstore.admin.service.ILogininforService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author YDF
 * @Description 系统访问记录
 * @Date 2019/3/13 0013 14:30
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/logininfor")
public class LogininforController extends BaseController {
	private String prefix = "monitor/logininfor";
	
	@Autowired
	private ILogininforService logininforService;
	
	@RequiresPermissions("monitor:logininfor:view")
	@GetMapping()
	public String logininfor() {
		return prefix + "/logininfor";
	}
	
	@RequiresPermissions("monitor:logininfor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Logininfor logininfor) {
		startPage();
		List<Logininfor> list = logininforService.selectLogininforList(logininfor);
		return getDataTable(list);
	}
	
	@Log(title = "登陆日志", businessType = BusinessType.EXPORT)
	@RequiresPermissions("monitor:logininfor:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Logininfor logininfor) {
		List<Logininfor> list = logininforService.selectLogininforList(logininfor);
		ExcelUtil<Logininfor> util = new ExcelUtil<Logininfor>(Logininfor.class);
		return util.exportExcel(list, "登陆日志");
	}
	
	@RequiresPermissions("monitor:logininfor:remove")
	@Log(title = "登陆日志", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(logininforService.deleteLogininforByIds(ids));
	}
	
	@RequiresPermissions("monitor:logininfor:remove")
	@Log(title = "登陆日志", businessType = BusinessType.CLEAN)
	@PostMapping("/clean")
	@ResponseBody
	public AjaxResult clean() {
		logininforService.cleanLogininfor();
		return success();
	}
}
