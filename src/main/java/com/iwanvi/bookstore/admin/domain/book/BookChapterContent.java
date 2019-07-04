package com.iwanvi.bookstore.admin.domain.book;

/**
 * @Author YDF
 * @Description 图书章节内容
 * @Date 下午 2:23 2019/4/1 0001
 * @Param
 * @return
 **/
public class BookChapterContent {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String content;

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
     * @return content 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}