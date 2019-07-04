package com.iwanvi.bookstore.admin.common.aspectj.lang.annotation;

import com.iwanvi.bookstore.admin.common.aspectj.lang.enums.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author YDF
 * @Description 自定义多数据源切换注解
 * @Date 2019/3/12 0012 10:25
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
	/**
	 * 切换数据源名称
	 */
	public DataSourceType value() default DataSourceType.MASTER;
}
