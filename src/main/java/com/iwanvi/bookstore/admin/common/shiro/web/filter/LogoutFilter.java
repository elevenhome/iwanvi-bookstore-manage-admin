package com.iwanvi.bookstore.admin.common.shiro.web.filter;

import com.iwanvi.bookstore.admin.common.constant.Constants;
import com.iwanvi.bookstore.admin.common.manager.AsyncManager;
import com.iwanvi.bookstore.admin.common.manager.factory.AsyncFactory;
import com.iwanvi.bookstore.admin.common.util.MessageUtils;
import com.iwanvi.bookstore.admin.common.util.ShiroUtils;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import com.iwanvi.bookstore.admin.domain.User;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author YDF
 * @Description 退出过滤器
 * @Date 2019/3/12 0012 11:38
 * @Version 1.0
 **/
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {
	private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);
	
	/**
	 * 退出后重定向的地址
	 */
	private String loginUrl;
	
	public String getLoginUrl() {
		return loginUrl;
	}
	
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		try {
			Subject subject = getSubject(request, response);
			String redirectUrl = getRedirectUrl(request, response, subject);
			try {
				User user = ShiroUtils.getSysUser();
				if (StringUtils.isNotNull(user)) {
					String loginName = user.getLoginName();
					// 记录用户退出日志
					AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGOUT, MessageUtils.message("user.logout.success")));
				}
				// 退出登录
				subject.logout();
			} catch (SessionException ise) {
				log.error("logout fail.", ise);
			}
			issueRedirect(request, response, redirectUrl);
		} catch (Exception e) {
			log.error("Encountered session exception during logout.  This can generally safely be ignored.", e);
		}
		return false;
	}
	
	/**
	 * 退出跳转URL
	 */
	@Override
	protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
		String url = getLoginUrl();
		if (StringUtils.isNotEmpty(url)) {
			return url;
		}
		return super.getRedirectUrl(request, response, subject);
	}
}
