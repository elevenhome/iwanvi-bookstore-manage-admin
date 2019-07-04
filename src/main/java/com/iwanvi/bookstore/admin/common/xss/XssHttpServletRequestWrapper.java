package com.iwanvi.bookstore.admin.common.xss;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Author YDF
 * @Description XSS过滤处理
 * @Date 2019/3/12 0012 18:02
 * @Version 1.0
 **/
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	/**
	 * @param request
	 */
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values != null) {
			int length = values.length;
			String[] escapseValues = new String[length];
			for (int i = 0; i < length; i++) {
				// 防xss攻击和过滤前后空格
				escapseValues[i] = Jsoup.clean(values[i], Whitelist.relaxed()).trim();
			}
			return escapseValues;
		}
		return super.getParameterValues(name);
	}
}