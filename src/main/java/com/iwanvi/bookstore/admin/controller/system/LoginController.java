package com.iwanvi.bookstore.admin.controller.system;

import com.iwanvi.bookstore.admin.common.util.AjaxResult;
import com.iwanvi.bookstore.admin.common.util.ServletUtils;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import com.iwanvi.bookstore.admin.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author YDF
 * @Description 登录验证
 * @Date 2019/3/12 0012 13:32
 * @Version 1.0
 **/
@Controller
public class LoginController extends BaseController {
	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		// 如果是Ajax请求，返回Json字符串。
		if (ServletUtils.isAjaxRequest(request)) {
			return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
		}
		return "login";
	}
	
	/**
	 * @Author YDF
	 * @Description ajax登录方式
	 * @Date 2019/3/12 0012 13:45
	 * @Version 1.0
	 **/
	@PostMapping("/login")
	@ResponseBody
	public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return success();
		} catch (AuthenticationException e) {
			String msg = "用户或密码错误";
			if (StringUtils.isNotEmpty(e.getMessage())) {
				msg = e.getMessage();
			}
			return error(msg);
		}
	}
	
	/**
	 * @Author YDF
	 * @Description 无权限
	 * @Date 2019/3/12 0012 13:39
	 * @Version 1.0
	 **/
	@GetMapping("/unauth")
	public String unauth() {
		return "/error/unauth";
	}
}
