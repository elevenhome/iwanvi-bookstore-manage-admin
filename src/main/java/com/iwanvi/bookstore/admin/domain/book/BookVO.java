package com.iwanvi.bookstore.admin.domain.book;

/**
 * @Author YDF
 * @Description //TODO 图书返回数据对象
 * @Date 17:43 2018/11/14 0014
 * @Param
 * @return
 **/
public class BookVO {
    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 封面
     */
    private String bookImg;
    
    /**
     * 封面
     */
    private String authorName;

    /**
     * 字数
     */
    private String wordCount;

    /**
     * 图书id
     */
    private String bookId;

    /**
     * 最后更新章节时间
     */
    private String updateDate;

    /**
     * 01是连载，02是暂停，03是完本
     */
    private String bookStatue;

    /**
     * 简介
     */
    private String introduction;
	private String categoryName;//分类名称
	private String categoryColor;//分类颜色
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookImg() {
		return bookImg;
	}
	
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getWordCount() {
		return wordCount;
	}
	
	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getBookStatue() {
		return bookStatue;
	}
	
	public void setBookStatue(String bookStatue) {
		this.bookStatue = bookStatue;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryColor() {
		return categoryColor;
	}
	
	public void setCategoryColor(String categoryColor) {
		this.categoryColor = categoryColor;
	}
	
	@Override
	public String toString() {
		return "BookVO{" +
				"bookName='" + bookName + '\'' +
				", bookImg='" + bookImg + '\'' +
				", authorName='" + authorName + '\'' +
				", wordCount=" + wordCount +
				", bookId='" + bookId + '\'' +
				", updateDate='" + updateDate + '\'' +
				", bookStatue='" + bookStatue + '\'' +
				", introduction='" + introduction + '\'' +
				", categoryName='" + categoryName + '\'' +
				", categoryColor='" + categoryColor + '\'' +
				'}';
	}
}