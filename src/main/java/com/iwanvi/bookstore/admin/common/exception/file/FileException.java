package com.iwanvi.bookstore.admin.common.exception.file;

import com.iwanvi.bookstore.admin.common.exception.BaseException;

/**
 * @Author YDF
 * @Description 文件信息异常类
 * @Date 2019/3/12 0012 18:51
 * @Version 1.0
 **/
public class FileException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public FileException(String code, Object[] args) {
		super("file", code, args, null);
	}
	
}
