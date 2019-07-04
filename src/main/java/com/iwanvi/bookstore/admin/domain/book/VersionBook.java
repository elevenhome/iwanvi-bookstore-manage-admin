package com.iwanvi.bookstore.admin.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iwanvi.bookstore.admin.domain.BaseEntity;

/**
 * 版本书单表 version_book
 * @author iwanvi
 * @date 2019-04-03
 */
public class VersionBook extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/** 编号 */
	private Integer id;
	/** 书单编号 */
	private Integer bookListId;
	/** 图书ID */
	private String bookId;
	/** 封面 */
	private String imgUrl;
	/** 作者 */
	private String bookAuthor;
	/** 新书名 */
	private String newBookName;
	/** 简介 */
	private String introduction;
	/** 新价格 */
	private Double newPrice;
	/** 关键词 */
	private String keyWord;
	/** 点击数 */
	private Integer clickCount;
	/** 下载数 */
	private Integer downloadCount;
	/** 订阅数 */
	private Integer subscriptionCount;
	/** 收藏数 */
	private Integer collectionCount;
	/** 分享数 */
	private Integer shareCount;
	/** 阅读章节数 */
	private Integer readChapterCount;
	/** 状态：1正常，0失效 */
	private Integer status;
	/** 备注 */
	private String remark;
	/** 批量选择的图书ID */
	private String bookIds;
	/** 短简介 */
	private String shortIntroduction;
	/** 推荐语 */
	private String recommended;
	/** 长简介 */
	private String longIntroduction;
	private ProfessionalDictData dictData;

	public ProfessionalDictData getDictData() {
		return dictData;
	}

	public void setDictData(ProfessionalDictData dictData) {
		this.dictData = dictData;
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
	public void setBookListId(Integer bookListId) {
		this.bookListId = bookListId;
	}

	public Integer getBookListId() {
		return bookListId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookId() {
		return bookId;
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
	public void setNewBookName(String newBookName) {
		this.newBookName = newBookName;
	}

	public String getNewBookName() {
		return newBookName;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return introduction;
	}
	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public Double getNewPrice() {
		return newPrice;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return keyWord;
	}
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getClickCount() {
		return clickCount;
	}
	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}

	public Integer getDownloadCount() {
		return downloadCount;
	}
	public void setSubscriptionCount(Integer subscriptionCount) {
		this.subscriptionCount = subscriptionCount;
	}

	public Integer getSubscriptionCount() {
		return subscriptionCount;
	}
	public void setCollectionCount(Integer collectionCount) {
		this.collectionCount = collectionCount;
	}

	public Integer getCollectionCount() {
		return collectionCount;
	}
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getShareCount() {
		return shareCount;
	}
	public void setReadChapterCount(Integer readChapterCount) {
		this.readChapterCount = readChapterCount;
	}

	public Integer getReadChapterCount() {
		return readChapterCount;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bookListId", getBookListId())
            .append("bookId", getBookId())
            .append("imgUrl", getImgUrl())
            .append("bookAuthor", getBookAuthor())
            .append("newBookName", getNewBookName())
            .append("introduction", getIntroduction())
            .append("newPrice", getNewPrice())
            .append("keyWord", getKeyWord())
            .append("clickCount", getClickCount())
            .append("downloadCount", getDownloadCount())
            .append("subscriptionCount", getSubscriptionCount())
            .append("collectionCount", getCollectionCount())
            .append("shareCount", getShareCount())
            .append("readChapterCount", getReadChapterCount())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
