package com.iwanvi.bookstore.admin.common.page;

import com.iwanvi.bookstore.admin.common.constant.Constants;
import com.iwanvi.bookstore.admin.common.util.ServletUtils;

/**
 * @Author YDF
 * @Description 表格数据处理
 * @Date 2019/3/12 0012 9:48
 * @Version 1.0
 **/
public class TableSupport {
	/**
	 * 封装分页对象
	 */
	public static PageDomain getPageDomain() {
		PageDomain pageDomain = new PageDomain();
		pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
		pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
		pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
		pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
		return pageDomain;
	}
	
	public static PageDomain buildPageRequest() {
		return getPageDomain();
	}
}
