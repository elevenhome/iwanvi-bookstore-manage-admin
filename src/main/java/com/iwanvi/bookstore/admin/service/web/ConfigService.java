package com.iwanvi.bookstore.admin.service.web;

import com.iwanvi.bookstore.admin.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author YDF
 * @Description html调用 thymeleaf 实现参数管理
 * @Date 2019/3/12 0012 19:14
 * @Version 1.0
 **/
@Service("config")
public class ConfigService {
	@Autowired
	private IConfigService configService;
	
	/**
	 * 根据键名查询参数配置信息
	 * @param configKey 参数名称
	 * @return 参数键值
	 */
	public String getKey(String configKey) {
		return configService.selectConfigByKey(configKey);
	}
	
}
