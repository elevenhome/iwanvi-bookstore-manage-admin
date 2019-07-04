package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author YDF
 * @Description druid SQL监控
 * @Date 2019/3/13 0013 14:26
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/data")
public class DruidController extends BaseController {
	private String prefix = "/monitor/druid";
	
	@RequiresPermissions("monitor:data:view")
	@GetMapping()
	public String index() {
		return redirect(prefix + "/index");
	}
}
