package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.server.Server;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author YDF
 * @Description 服务器监控
 * @Date 2019/3/13 0013 14:35
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {
	private String prefix = "monitor/server";
	
	@RequiresPermissions("monitor:server:view")
	@GetMapping()
	public String server(ModelMap mmap) throws Exception {
		Server server = new Server();
		server.copyTo();
		mmap.put("server", server);
		return prefix + "/server";
	}
}
