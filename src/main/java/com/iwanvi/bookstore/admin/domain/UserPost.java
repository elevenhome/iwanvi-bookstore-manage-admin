package com.iwanvi.bookstore.admin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author YDF
 * @Description 用户和岗位关联 sys_user_post
 * @Date 2019/3/12 0012 13:57
 * @Version 1.0
 **/
public class UserPost {
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 岗位ID
	 */
	private Long postId;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("userId", getUserId())
				.append("postId", getPostId())
				.toString();
	}
}
