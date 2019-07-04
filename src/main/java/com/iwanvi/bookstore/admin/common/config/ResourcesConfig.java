package com.iwanvi.bookstore.admin.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author YDF
 * @Description 通用配置
 * @Date 2019/3/12 0012 18:04
 * @Version 1.0
 **/
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
	/**
	 * 首页地址
	 */
	@Value("${shiro.user.indexUrl}")
	private String indexUrl;
	
	/**
	 * 默认首页的设置，当输入域名是可以自动跳转到默认指定的网页
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:" + indexUrl);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/** 文件上传路径 */
		registry.addResourceHandler("/profile/**").addResourceLocations("file:" + RuoYiConfig.getProfile());
		
		/** swagger配置 */
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/**
	 * web跨域访问配置,全局CORS配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry){
		// 设置允许跨域的路径
		registry.addMapping("/**")
				// 设置允许跨域请求的域名
				.allowedOrigins("*")
				// 是否允许证书
				.allowCredentials(true)
				// 设置允许的方法
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				// 设置允许的header属性
				.allowedHeaders("*")
				// 跨域允许时间
				.maxAge(3600);
	}
}