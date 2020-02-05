package com.iwanvi.bookstore.admin.service.impl;

import com.iwanvi.bookstore.admin.common.constant.UserConstants;
import com.iwanvi.bookstore.admin.common.exception.BusinessException;
import com.iwanvi.bookstore.admin.common.support.Convert;
import com.iwanvi.bookstore.admin.common.util.ShiroUtils;
import com.iwanvi.bookstore.admin.common.util.StringUtils;
import com.iwanvi.bookstore.admin.dao.PostMapper;
import com.iwanvi.bookstore.admin.dao.UserPostMapper;
import com.iwanvi.bookstore.admin.domain.Post;
import com.iwanvi.bookstore.admin.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YDF
 * @Description 岗位信息 服务层处理
 * @Date 2019/3/12 0012 11:17
 * @Version 1.0
 **/
@Service
public class PostServiceImpl implements IPostService {
	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private UserPostMapper userPostMapper;
	
	/**
	 * 查询岗位信息集合
	 *
	 * @param post 岗位信息
	 * @return 岗位信息集合
	 */
	@Override
	public List<Post> selectPostList(Post post) {
		return postMapper.selectPostList(post);
	}
	
	/**
	 * 查询所有岗位
	 *
	 * @return 岗位列表
	 */
	@Override
	public List<Post> selectPostAll() {
		return postMapper.selectPostAll();
	}
	
	/**
	 * 根据用户ID查询岗位
	 *
	 * @param userId 用户ID
	 * @return 岗位列表
	 */
	@Override
	public List<Post> selectPostsByUserId(Long userId) {
		List<Post> userPosts = postMapper.selectPostsByUserId(userId);
		List<Post> posts = postMapper.selectPostAll();
		for (Post post : posts) {
			for (Post userRole : userPosts) {
				if (post.getPostId().longValue() == userRole.getPostId().longValue()) {
					post.setFlag(true);
					break;
				}
			}
		}
		return posts;
	}
	
	/**
	 * 通过岗位ID查询岗位信息
	 *
	 * @param postId 岗位ID
	 * @return 角色对象信息
	 */
	@Override
	public Post selectPostById(Long postId) {
		return postMapper.selectPostById(postId);
	}
	
	/**
	 * 批量删除岗位信息
	 *
	 * @param ids 需要删除的数据ID
	 * @throws Exception
	 */
	@Override
	public int deletePostByIds(String ids) throws BusinessException {
		Long[] postIds = Convert.toLongArray(ids);
		for (Long postId : postIds) {
			Post post = selectPostById(postId);
			if (countUserPostById(postId) > 0) {
				throw new BusinessException(String.format("%1$s已分配,不能删除", post.getPostName()));
			}
		}
		return postMapper.deletePostByIds(postIds);
	}
	
	/**
	 * 新增保存岗位信息
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	@Override
	public int insertPost(Post post) {
		post.setCreateBy(ShiroUtils.getLoginName());
		return postMapper.insertPost(post);
	}
	
	/**
	 * 修改保存岗位信息
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	@Override
	public int updatePost(Post post) {
		post.setUpdateBy(ShiroUtils.getLoginName());
		return postMapper.updatePost(post);
	}
	
	/**
	 * 通过岗位ID查询岗位使用数量
	 *
	 * @param postId 岗位ID
	 * @return 结果
	 */
	@Override
	public int countUserPostById(Long postId) {
		return userPostMapper.countUserPostById(postId);
	}
	
	/**
	 * 校验岗位名称是否唯一
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	@Override
	public String checkPostNameUnique(Post post) {
		Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
		Post info = postMapper.checkPostNameUnique(post.getPostName());
		if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue()) {
			return UserConstants.POST_NAME_NOT_UNIQUE;
		}
		return UserConstants.POST_NAME_UNIQUE;
	}
	
	/**
	 * 校验岗位编码是否唯一
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	@Override
	public String checkPostCodeUnique(Post post) {
		Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
		Post info = postMapper.checkPostCodeUnique(post.getPostCode());
		if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue()) {
			return UserConstants.POST_CODE_NOT_UNIQUE;
		}
		return UserConstants.POST_CODE_UNIQUE;
	}
}