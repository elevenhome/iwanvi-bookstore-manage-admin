package com.iwanvi.bookstore.admin.common.util;

import org.springframework.context.MessageSource;

/**
 * @Author YDF
 * @Description 获取i18n资源文件
 * @Date 2019/3/12 0012 10:20
 * @Version 1.0
 **/
public class MessageUtils {
	/**
	 * 根据消息键和参数 获取消息 委托给spring messageSource
	 *
	 * @param code 消息键
	 * @param args 参数
	 * @return
	 */
	public static String message(String code, Object... args) {
		MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
		return messageSource.getMessage(code, args, null);
	}
}
