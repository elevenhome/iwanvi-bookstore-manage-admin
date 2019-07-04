package com.iwanvi.bookstore.admin.domain.book;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Excel;
import com.iwanvi.bookstore.admin.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 图书表 book_center
 *
 * @author YDF
 * @date 2019-03-13
 */
public class BookCenter extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	@Excel(name = "编号")
	private Integer id;
	/**
	 * 书名
	 */
	@Excel(name = "书名")
	private String bookName;
	/**
	 * 图书ID
	 */
	@Excel(name = "图书ID")
	private String bookId;
	/**
	 * 作者
	 */
	@Excel(name = "作者")
	private String bookAuthor;
	/**
	 * 简介
	 */
	@Excel(name = "简介")
	private String introduction;
	/**
	 * 字数
	 */
	@Excel(name = "字数")
	private Integer wordCount;
	/**
	 * 分类
	 */
	@Excel(name = "分类")
	private Integer categoryId;
	/**
	 * 二级分类
	 */
	@Excel(name = "二级分类")
	private Integer categorySec;
	/**
	 * 三级分类
	 */
	@Excel(name = "三级分类")
	private Integer categoryThr;
	/**
	 * 关键词
	 */
	@Excel(name = "关键词")
	private String keyWord;
	/**
	 * 状态：1在线，0或者-1下线
	 */
	//@Excel(name = "状态", readConverterExp = "1=在线,-1=下线,-2=下线,-3=下线")
	@Excel(name = "状态")
	private Integer status;
	/**
	 * 创建时间
	 */
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	/**
	 * 修改时间
	 */
	@Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	/**
	 * 最后更新章节时间
	 */
	@Excel(name = "最后更新章节时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateChapterDate;
	/**
	 * 最后更新章节名
	 */
	@Excel(name = "最后更新章节名")
	private String lastUpdateChapterName;
	/**
	 * 最后更新章节ID
	 */
	@Excel(name = "最后更新章节ID")
	private Integer lastUpdateChapterId;
	/**
	 * 图书状态：01是连载，02是暂停，03是完本
	 */
	//@Excel(name = "图书更新状态", readConverterExp = "01=连载,02=暂停更新,03=完本")
	@Excel(name = "图书更新状态")
	private String bookStatus;
	/**
	 * 频道ID:0全部,1男生,2女生,3出版物
	 */
	//@Excel(name = "频道ID", readConverterExp = "0=全部,1=男生,2=女生,3=出版物")
	@Excel(name = "频道ID")
	private Integer pindaoId;
	/** 短简介 */
	@Excel(name = "短简介")
	private String shortIntroduction;
	/** 推荐语 */
	@Excel(name = "推荐语")
	private String recommended;
	/** 长简介 */
	@Excel(name = "长简介")
	private String longIntroduction;
	/**
	 * 章节数
	 */
	@Excel(name = "章节数")
	private Integer chapterCount;
	/**
	 * 自定义书名
	 */
	private String newBookName;
	/**
	 * 封面
	 */
	private String imgUrl;
	/**
	 * ISBN
	 */
	private String isbn;
	/**
	 * 出版社
	 */
	private String publish;
	/**
	 * 是否有卷：0无，1有
	 */
	private Integer haveVolume;
	/**
	 * 渠道编号
	 */
	private Integer channel;
	/**
	 * 价格
	 */
	private Double bookPrice;
	/**
	 * 版权到期时间
	 */
	private Date copyrightTime;
	/**
	 * 其他信息
	 */
	private String otherInfo;
	/**
	 * 自定义图书ID
	 */
	private String newBookId;
	/**
	 * 同步图书ID
	 */
	private String syncBookId;
	/**
	 * 备注
	 */
	private String remark;
	/** 批量选择的图书ID */
	private String bookIds;	

	public Integer getChapterCount() {
		return chapterCount;
	}

	public void setChapterCount(Integer chapterCount) {
		this.chapterCount = chapterCount;
	}

	public String getShortIntroduction() {
		return shortIntroduction;
	}

	public void setShortIntroduction(String shortIntroduction) {
		this.shortIntroduction = shortIntroduction;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public String getLongIntroduction() {
		return longIntroduction;
	}

	public void setLongIntroduction(String longIntroduction) {
		this.longIntroduction = longIntroduction;
	}

	public Integer getPindaoId() {
		return pindaoId;
	}
	
	public void setPindaoId(Integer pindaoId) {
		this.pindaoId = pindaoId;
	}
	
	public String getBookIds() {
		return bookIds;
	}
	
	public void setBookIds(String bookIds) {
		this.bookIds = bookIds;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setNewBookName(String newBookName) {
		this.newBookName = newBookName;
	}
	
	public String getNewBookName() {
		return newBookName;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	
	public Integer getWordCount() {
		return wordCount;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategorySec(Integer categorySec) {
		this.categorySec = categorySec;
	}
	
	public Integer getCategorySec() {
		return categorySec;
	}
	
	public void setCategoryThr(Integer categoryThr) {
		this.categoryThr = categoryThr;
	}
	
	public Integer getCategoryThr() {
		return categoryThr;
	}
	
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	public String getPublish() {
		return publish;
	}
	
	public void setHaveVolume(Integer haveVolume) {
		this.haveVolume = haveVolume;
	}
	
	public Integer getHaveVolume() {
		return haveVolume;
	}
	
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	
	public Integer getChannel() {
		return channel;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public Double getBookPrice() {
		return bookPrice;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setCopyrightTime(Date copyrightTime) {
		this.copyrightTime = copyrightTime;
	}
	
	public Date getCopyrightTime() {
		return copyrightTime;
	}
	
	public void setLastUpdateChapterDate(Date lastUpdateChapterDate) {
		this.lastUpdateChapterDate = lastUpdateChapterDate;
	}
	
	public Date getLastUpdateChapterDate() {
		return lastUpdateChapterDate;
	}
	
	public void setLastUpdateChapterName(String lastUpdateChapterName) {
		this.lastUpdateChapterName = lastUpdateChapterName;
	}
	
	public String getLastUpdateChapterName() {
		return lastUpdateChapterName;
	}
	
	public void setLastUpdateChapterId(Integer lastUpdateChapterId) {
		this.lastUpdateChapterId = lastUpdateChapterId;
	}
	
	public Integer getLastUpdateChapterId() {
		return lastUpdateChapterId;
	}
	
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	public String getBookStatus() {
		return bookStatus;
	}
	
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	
	public void setNewBookId(String newBookId) {
		this.newBookId = newBookId;
	}
	
	public String getNewBookId() {
		return newBookId;
	}
	
	public void setSyncBookId(String syncBookId) {
		this.syncBookId = syncBookId;
	}
	
	public String getSyncBookId() {
		return syncBookId;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("bookName", getBookName())
				.append("bookId", getBookId())
				.append("newBookName", getNewBookName())
				.append("imgUrl", getImgUrl())
				.append("bookAuthor", getBookAuthor())
				.append("introduction", getIntroduction())
				.append("wordCount", getWordCount())
				.append("categoryId", getCategoryId())
				.append("categorySec", getCategorySec())
				.append("categoryThr", getCategoryThr())
				.append("keyWord", getKeyWord())
				.append("isbn", getIsbn())
				.append("publish", getPublish())
				.append("haveVolume", getHaveVolume())
				.append("channel", getChannel())
				.append("status", getStatus())
				.append("bookPrice", getBookPrice())
				.append("createDate", getCreateDate())
				.append("updateDate", getUpdateDate())
				.append("copyrightTime", getCopyrightTime())
				.append("lastUpdateChapterDate", getLastUpdateChapterDate())
				.append("lastUpdateChapterName", getLastUpdateChapterName())
				.append("lastUpdateChapterId", getLastUpdateChapterId())
				.append("bookStatus", getBookStatus())
				.append("otherInfo", getOtherInfo())
				.append("newBookId", getNewBookId())
				.append("syncBookId", getSyncBookId())
				.append("remark", getRemark())
				.toString();
	}
}
