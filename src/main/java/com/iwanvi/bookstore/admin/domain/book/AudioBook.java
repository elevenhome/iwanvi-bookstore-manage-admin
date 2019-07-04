package com.iwanvi.bookstore.admin.domain.book;

import com.iwanvi.bookstore.admin.common.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iwanvi.bookstore.admin.domain.BaseEntity;
import java.util.Date;

/**
 * 图书音频表 audio_book
 * @author iwanvi
 * @date 2019-06-11
 */
public class AudioBook extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/** ID，自增主键 */
	@Excel(name = "编号")
	private Long id;
	/** 音频图书ID */
	@Excel(name = "图书ID")
	private String bookId;
	/** 音频标题 */
	@Excel(name = "音频标题")
	private String title;
	/** 封面/正封面图片地址 */
	private String imgUrl;
	/** 长封面图片地址 */
	private String longImgUrl;
	/** 图书简介 */
	@Excel(name = "简介")
	private String introduction;
	/** 短简介 */
	@Excel(name = "短简介")
	private String shortIntroduction;
	/** 音频时长 */
	@Excel(name = "音频时长")
	private Integer audioTime;
	/** 作者名称 */
	@Excel(name = "作者")
	private String authorName;
	/** 图书状态，小于0 未上线  大于0上线 0 待审核状态 */
	@Excel(name = "状态", readConverterExp = "0=待审核,1=在线,-1=下线,-2=下线,-3=下线")
	private Integer status;
	/** 1 连载 2 暂停更新 3 完本 */
	@Excel(name = "图书更新状态", readConverterExp = "01=连载,02=暂停更新,03=完本")
	private Integer audioStatus;
	/** 分类 */
	@Excel(name = "分类")
	private Long categoryId;
	/** 一级分类 */
	@Excel(name = "一级分类")
	private Integer firstCategoryId;
	/** 二级分类 */
	@Excel(name = "二级分类")
	private Integer secondCategoryId;
	/** 音频总时长 */
	@Excel(name = "音频总时长")
	private Integer totalTime;
	/** 音频总大小 */
	@Excel(name = "音频总大小")
	private Long totalSize;
	/** 章节数 */
	@Excel(name = "章节数")
	private Integer totalChapter;
	/** 摘要（用于唯一标识书籍） */
	@Excel(name = "摘要")
	private String digest;
	/** 演讲者名称 */
	@Excel(name = "演讲者名称")
	private String lecturer;
	/** 演讲者简介/主播简介 */
	@Excel(name = "主播简介")
	private String lecturerIntroduction;
	/** 音频图书关键字，图书标签 */
	private String keyword;
	/** 出版时间 */
	@Excel(name = "出版时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	private Date publishTime;
	/** 音频创作时间 */
	@Excel(name = "音频创作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	private Date createDate;
	/** 音频修改时间 */
	@Excel(name = "音频修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	private Date updateDate;
	/** 最后一章ID */
	@Excel(name = "最后更新章节ID")
	private Integer lastUpdateChapterId;
	/** 最后一章更新时间 */
	@Excel(name = "最后一章更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	private Date lastUpdateChapterDate;
	/** 最后一章名称 */
	@Excel(name = "最后更新章节名")
	private String lastUpdateChapterName;
	/** 系统入库时间 */
	@Excel(name = "系统入库时间")
	private Date sysCreateDate;
	/** 系统修改时间 */
	@Excel(name = "系统修改时间")
	private Date sysUpdateDate;
	/** cpId */
	private String cpId;
	/** cp名称 */
	private String cpName;
	/** 批量选择的图书ID */
	private String bookIds;

	public String getBookIds() {
		return bookIds;
	}

	public void setBookIds(String bookIds) {
		this.bookIds = bookIds;
	}

	public Integer getFirstCategoryId() {
		return firstCategoryId;
	}

	public void setFirstCategoryId(Integer firstCategoryId) {
		this.firstCategoryId = firstCategoryId;
	}

	public Integer getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(Integer secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getTotalChapter() {
		return totalChapter;
	}

	public void setTotalChapter(Integer totalChapter) {
		this.totalChapter = totalChapter;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookId() {
		return bookId;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public void setLongImgUrl(String longImgUrl) {
		this.longImgUrl = longImgUrl;
	}

	public String getLongImgUrl() {
		return longImgUrl;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return introduction;
	}
	public void setShortIntroduction(String shortIntroduction) {
		this.shortIntroduction = shortIntroduction;
	}

	public String getShortIntroduction() {
		return shortIntroduction;
	}
	public void setAudioTime(Integer audioTime) {
		this.audioTime = audioTime;
	}

	public Integer getAudioTime() {
		return audioTime;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	public void setAudioStatus(Integer audioStatus) {
		this.audioStatus = audioStatus;
	}

	public Integer getAudioStatus() {
		return audioStatus;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getDigest() {
		return digest;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getLecturer() {
		return lecturer;
	}
	public void setLecturerIntroduction(String lecturerIntroduction) {
		this.lecturerIntroduction = lecturerIntroduction;
	}

	public String getLecturerIntroduction() {
		return lecturerIntroduction;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getPublishTime() {
		return publishTime;
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
	public void setLastUpdateChapterId(Integer lastUpdateChapterId) {
		this.lastUpdateChapterId = lastUpdateChapterId;
	}

	public Integer getLastUpdateChapterId() {
		return lastUpdateChapterId;
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
	public void setSysCreateDate(Date sysCreateDate) {
		this.sysCreateDate = sysCreateDate;
	}

	public Date getSysCreateDate() {
		return sysCreateDate;
	}
	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getCpId() {
		return cpId;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getCpName() {
		return cpName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bookId", getBookId())
            .append("title", getTitle())
            .append("imgUrl", getImgUrl())
            .append("longImgUrl", getLongImgUrl())
            .append("introduction", getIntroduction())
            .append("shortIntroduction", getShortIntroduction())
            .append("audioTime", getAudioTime())
            .append("authorName", getAuthorName())
            .append("status", getStatus())
            .append("audioStatus", getAudioStatus())
            .append("categoryId", getCategoryId())
            .append("digest", getDigest())
            .append("lecturer", getLecturer())
            .append("lecturerIntroduction", getLecturerIntroduction())
            .append("keyword", getKeyword())
            .append("publishTime", getPublishTime())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("lastUpdateChapterId", getLastUpdateChapterId())
            .append("lastUpdateChapterDate", getLastUpdateChapterDate())
            .append("lastUpdateChapterName", getLastUpdateChapterName())
            .append("sysCreateDate", getSysCreateDate())
            .append("sysUpdateDate", getSysUpdateDate())
            .append("cpId", getCpId())
            .append("cpName", getCpName())
            .toString();
    }
}
