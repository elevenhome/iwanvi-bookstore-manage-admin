package com.iwanvi.bookstore.admin.common.exception.file;

/**
 * @Author YDF
 * @Description 文件名称超长限制异常类
 * @Date 2019/3/12 0012 18:52
 * @Version 1.0
 **/
public class FileNameLengthLimitExceededException extends FileException {
	private static final long serialVersionUID = 1L;
	
	public FileNameLengthLimitExceededException(int defaultFileNameLength) {
		super("upload.filename.exceed.length", new Object[]{defaultFileNameLength});
	}
}
