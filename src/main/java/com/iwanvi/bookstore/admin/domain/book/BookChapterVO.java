package com.iwanvi.bookstore.admin.domain.book;

/**
 * @Author YDF
 * @Description 图书章节
 * @Date 17:07 2018/11/6 0006
 **/
public class BookChapterVO {
    private int id;//章ID
    private String name;//章名
    private String isVip;//是否VIP
	private Integer idx;//顺序

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }
	
	@Override
	public String toString() {
		return "BookChapterVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", isVip='" + isVip + '\'' +
				", idx=" + idx +
				'}';
	}
}
