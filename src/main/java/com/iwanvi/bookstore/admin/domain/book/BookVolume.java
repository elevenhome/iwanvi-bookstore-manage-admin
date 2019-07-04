package com.iwanvi.bookstore.admin.domain.book;

import java.util.List;

/**
 * @Author YDF
 * @Description 图书卷
 * @Date 2019/2/19 0019 17:11
 * @Version 1.0
 **/
public class BookVolume {
    private Integer id;
    private Integer idx;
    private String name;
    private String bookId;
    private String code;
    private String other;
    private String cpVolumeId;
	private List<BookChapterVO> bookChapters;//章列表
	private int buyout;  // 书籍买断标识

	public List<BookChapterVO> getBookChapters() {
		return this.bookChapters;
	}

	public void setBookChapters(List<BookChapterVO> bookChapters) {
		this.bookChapters = bookChapters;
	}

	public int getBuyout() {
		return this.buyout;
	}

	public void setBuyout(int buyout) {
		this.buyout = buyout;
	}

	/**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return idx 
     */
    public Integer getIdx() {
        return idx;
    }

    /**
     * 
     * @param idx 
     */
    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) {
		this.other = other;
	}
	
	public String getCpVolumeId() {
		return cpVolumeId;
	}
	
	public void setCpVolumeId(String cpVolumeId) {
		this.cpVolumeId = cpVolumeId;
	}
}