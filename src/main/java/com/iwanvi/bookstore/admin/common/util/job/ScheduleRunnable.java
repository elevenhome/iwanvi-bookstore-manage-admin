package com.iwanvi.bookstore.admin.common.util.job;

import com.iwanvi.bookstore.admin.common.exception.BusinessException;
import com.iwanvi.bookstore.admin.common.util.SpringUtils;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @Author YDF
 * @Description 执行定时任务
 * @Date 2019/3/19 0019 16:38
 * @Version 1.0
 **/
public class ScheduleRunnable implements Runnable {
	private Object target;
	private Method method;
	private String params;
	
	public ScheduleRunnable(String beanName, String methodName, String params)
			throws NoSuchMethodException, SecurityException {
		this.target = SpringUtils.getBean(beanName);
		this.params = params;
		
		if (StringUtils.isNotEmpty(params)) {
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		} else {
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}
	
	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if (StringUtils.isNotEmpty(params)) {
				method.invoke(target, params);
			} else {
				method.invoke(target);
			}
		} catch (Exception e) {
			throw new BusinessException("执行定时任务失败", e);
		}
	}
}
