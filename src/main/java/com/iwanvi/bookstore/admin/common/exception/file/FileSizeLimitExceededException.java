package com.iwanvi.bookstore.admin.common.exception.file;

/**
 * @Author YDF
 * @Description 文件名大小限制异常类
 * @Date 2019/3/12 0012 18:52
 * @Version 1.0
 **/
public class FileSizeLimitExceededException extends FileException {
	private static final long serialVersionUID = 1L;
	
	public FileSizeLimitExceededException(long defaultMaxSize) {
		super("upload.exceed.maxSize", new Object[]{defaultMaxSize});
	}
}
