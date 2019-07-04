package com.iwanvi.bookstore.admin.domain.book;

import java.util.Date;

/**
 * @Author YDF
 * @Description 图书章节信息
 * @Date 下午 2:23 2019/4/1 0001
 * @Param
 * @return
 **/
public class BookChapter {
    private Integer id;

    private Integer idx;

    private Integer wordCount;

    private String name;

    private String bookid;

    private String cpautoid;

    private Integer chapterindex;

    private Integer volumeId;

    private String isvip;

    private Integer status;

    private Integer contentstatus;

    private Integer charge;

    private Date createDate;

    private Date updateDate;

    private Integer chapterNum;//章节总数

	public Integer getChapterNum() {
		return this.chapterNum;
	}

	public void setChapterNum(Integer chapterNum) {
		this.chapterNum = chapterNum;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }

    public String getCpautoid() {
        return cpautoid;
    }

    public void setCpautoid(String cpautoid) {
        this.cpautoid = cpautoid == null ? null : cpautoid.trim();
    }

    public Integer getChapterindex() {
        return chapterindex;
    }

    public void setChapterindex(Integer chapterindex) {
        this.chapterindex = chapterindex;
    }

    public Integer getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }

    public String getIsvip() {
        return isvip;
    }

    public void setIsvip(String isvip) {
        this.isvip = isvip == null ? null : isvip.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getContentstatus() {
        return contentstatus;
    }

    public void setContentstatus(Integer contentstatus) {
        this.contentstatus = contentstatus;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Date getCreateDate() {
        return (Date) createDate.clone();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = (Date) createDate.clone();
    }

    public Date getUpdateDate() {
        return (Date) updateDate.clone();
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = (Date) updateDate.clone();
    }
}