package com.iwanvi.bookstore.admin.common.config;

import com.google.common.collect.Maps;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import com.iwanvi.bookstore.admin.common.xss.XssFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.Map;

/**
 * @Author YDF
 * @Description Filter配置
 * @Date 2019/3/12 0012 18:00
 * @Version 1.0
 **/
@Configuration
public class FilterConfig {
	@Value("${xss.enabled}")
	private String enabled;
	
	@Value("${xss.excludes}")
	private String excludes;
	
	@Value("${xss.urlPatterns}")
	private String urlPatterns;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Bean
	public FilterRegistrationBean xssFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new XssFilter());
		registration.addUrlPatterns(StringUtils.split(urlPatterns, ","));
		registration.setName("xssFilter");
		registration.setOrder(Integer.MAX_VALUE);
		Map<String, String> initParameters = Maps.newHashMap();
		initParameters.put("excludes", excludes);
		initParameters.put("enabled", enabled);
		registration.setInitParameters(initParameters);
		return registration;
	}
}
