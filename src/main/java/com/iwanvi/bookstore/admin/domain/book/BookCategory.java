package com.iwanvi.bookstore.admin.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iwanvi.bookstore.admin.domain.BaseEntity;

/**
 * 图书分类表 book_category
 * @author iwanvi
 * @date 2019-04-23
 */
public class BookCategory extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/** 分类ID */
	private Integer id;
	/** 图书分类 */
	private String name;
	/** 作者分类 */
	private String authorCategory;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setAuthorCategory(String authorCategory) {
		this.authorCategory = authorCategory;
	}

	public String getAuthorCategory() {
		return authorCategory;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("authorCategory", getAuthorCategory())
            .toString();
    }
}
