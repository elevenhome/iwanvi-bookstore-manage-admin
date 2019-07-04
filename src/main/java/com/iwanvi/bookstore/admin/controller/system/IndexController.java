package com.iwanvi.bookstore.admin.controller.system;

import com.iwanvi.bookstore.admin.common.config.RuoYiConfig;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.Menu;
import com.iwanvi.bookstore.admin.domain.User;
import com.iwanvi.bookstore.admin.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author YDF
 * @Description 首页 业务处理
 * @Date 2019/3/12 0012 18:18
 * @Version 1.0
 **/
@Controller
public class IndexController extends BaseController {
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private RuoYiConfig ruoYiConfig;
	
	// 系统首页
	@GetMapping("/index")
	public String index(ModelMap mmap) {
		// 取身份信息
		User user = getSysUser();
		// 根据用户id取出菜单
		List<Menu> menus = menuService.selectMenusByUser(user);
		mmap.put("menus", menus);
		mmap.put("user", user);
		mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
		return "index";
	}
	
	// 系统介绍
	@GetMapping("/system/main")
	public String main(ModelMap mmap) {
		mmap.put("version", ruoYiConfig.getVersion());
		return "main";
	}
}
