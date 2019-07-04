package com.iwanvi.bookstore.admin.common.aspectj;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.DataSource;
import com.iwanvi.bookstore.admin.common.datasource.DynamicDataSourceContextHolder;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author YDF
 * @Description 多数据源处理
 * @Date 2019/3/12 0012 10:30
 * @Version 1.0
 **/
@Aspect
@Order(1)
@Component
public class DataSourceAspect {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("@annotation(com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.DataSource)")
	public void dsPointCut() {
	
	}
	
	@Around("dsPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		DataSource dataSource = method.getAnnotation(DataSource.class);
		if (StringUtils.isNotNull(dataSource)) {
			DynamicDataSourceContextHolder.setDateSoureType(dataSource.value().name());
		}
		try {
			return point.proceed();
		} finally {
			// 销毁数据源 在执行方法之后
			DynamicDataSourceContextHolder.clearDateSoureType();
		}
	}
}
