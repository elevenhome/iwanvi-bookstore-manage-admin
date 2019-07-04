package com.iwanvi.bookstore.admin.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author YDF
 * @Description 动态数据源
 * @Date 2019/3/12 0012 10:33
 * @Version 1.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
	public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
		super.setDefaultTargetDataSource(defaultTargetDataSource);
		super.setTargetDataSources(targetDataSources);
		super.afterPropertiesSet();
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDateSoureType();
	}
}