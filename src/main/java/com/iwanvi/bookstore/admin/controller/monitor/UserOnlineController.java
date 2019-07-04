package com.iwanvi.bookstore.admin.controller.monitor;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Log;
import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.BusinessType;
import com.iwanvi.bookstore.admin.common.page.TableDataInfo;
import com.iwanvi.bookstore.admin.common.shiro.session.OnlineSessionDAO;
import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ShiroUtils;
import com.iwanvi.bookstore.admin.controller.BaseController;
import com.iwanvi.bookstore.admin.domain.OnlineSession;
import com.iwanvi.bookstore.admin.domain.UserOnline;
import com.iwanvi.bookstore.admin.service.IUserOnlineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YDF
 * @Description 在线用户监控
 * @Date 2019/3/13 0013 14:31
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor/online")
public class UserOnlineController extends BaseController {
	private String prefix = "monitor/online";
	
	@Autowired
	private IUserOnlineService userOnlineService;
	
	@Autowired
	private OnlineSessionDAO onlineSessionDAO;
	
	@RequiresPermissions("monitor:online:view")
	@GetMapping()
	public String online() {
		return prefix + "/online";
	}
	
	@RequiresPermissions("monitor:online:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserOnline userOnline) {
		startPage();
		List<UserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
		return getDataTable(list);
	}
	
	@RequiresPermissions("monitor:online:batchForceLogout")
	@Log(title = "在线用户", businessType = BusinessType.FORCE)
	@PostMapping("/batchForceLogout")
	@ResponseBody
	public AjaxResult batchForceLogout(@RequestParam("ids[]") String[] ids) {
		for (String sessionId : ids) {
			UserOnline online = userOnlineService.selectOnlineById(sessionId);
			if (online == null) {
				return error("用户已下线");
			}
			OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
			if (onlineSession == null) {
				return error("用户已下线");
			}
			if (sessionId.equals(ShiroUtils.getSessionId())) {
				return error("当前登陆用户无法强退");
			}
			onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
			onlineSessionDAO.update(onlineSession);
			online.setStatus(OnlineSession.OnlineStatus.off_line);
			userOnlineService.saveOnline(online);
		}
		return success();
	}
	
	@RequiresPermissions("monitor:online:forceLogout")
	@Log(title = "在线用户", businessType = BusinessType.FORCE)
	@PostMapping("/forceLogout")
	@ResponseBody
	public AjaxResult forceLogout(String sessionId) {
		UserOnline online = userOnlineService.selectOnlineById(sessionId);
		if (sessionId.equals(ShiroUtils.getSessionId())) {
			return error("当前登陆用户无法强退");
		}
		if (online == null) {
			return error("用户已下线");
		}
		OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
		if (onlineSession == null) {
			return error("用户已下线");
		}
		onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
		onlineSessionDAO.update(onlineSession);
		online.setStatus(OnlineSession.OnlineStatus.off_line);
		userOnlineService.saveOnline(online);
		return success();
	}
}
