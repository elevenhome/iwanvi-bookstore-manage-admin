package com.iwanvi.bookstore.admin.common.aspectj.lang.annotation;

import java.lang.annotation.*;

/**
 * @Author YDF
 * @Description 数据权限过滤注解
 * @Date 2019/3/12 0012 10:28
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
	/**
	 * 表的别名
	 */
	public String tableAlias() default "";
}
