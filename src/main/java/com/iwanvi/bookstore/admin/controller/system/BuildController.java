package com.iwanvi.bookstore.admin.controller.system;

import com.iwanvi.bookstore.admin.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author YDF
 * @Description build 表单构建
 * @Date 2019/3/13 0013 15:03
 * @Version 1.0
 **/
@Controller
@RequestMapping("/tool/build")
public class BuildController extends BaseController {
	private String prefix = "tool/build";
	
	@RequiresPermissions("tool:build:view")
	@GetMapping()
	public String build() {
		return prefix + "/build";
	}
}
