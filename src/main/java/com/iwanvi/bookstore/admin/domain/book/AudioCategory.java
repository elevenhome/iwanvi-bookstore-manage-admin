package com.iwanvi.bookstore.admin.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iwanvi.bookstore.admin.domain.BaseEntity;
import java.util.Date;

/**
 * 图书音频分类表 audio_category
 * @author iwanvi
 * @date 2019-06-11
 */
public class AudioCategory extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/**  */
	private Long id;
	/** 分类ID */
	private Integer categoryId;
	/** 名称 */
	private String name;
	/** 父级ID */
	private Integer parentId;
	/** 级别 */
	private Integer level;
	/** 创建日期 */
	private Date createDate;
	/** 修改日期 */
	private Date updateDate;
	/** 排序 */
	private Integer idx;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParentId() {
		return parentId;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
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
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Integer getIdx() {
		return idx;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("name", getName())
            .append("parentId", getParentId())
            .append("level", getLevel())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("idx", getIdx())
            .toString();
    }
}
