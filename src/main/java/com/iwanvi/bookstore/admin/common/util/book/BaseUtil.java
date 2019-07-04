package com.iwanvi.bookstore.admin.common.util.book;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iwanvi.bookstore.admin.common.constant.Constants;
import com.iwanvi.bookstore.admin.common.util.DateUtils;
import com.iwanvi.bookstore.admin.common.util.HttpUtils;
import com.iwanvi.bookstore.admin.domain.book.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YDF
 * @Description 基础平台-图书服务中心接口
 * @Date 2019/4/1 0001 上午 11:09
 * @Version 1.0
 */
@Component
public class BaseUtil {
  /** 基础平台地址 */
  @Value("${base.url}")
  private String url;

  /**
   * @Author YDF
   * @Description 获取有声图书
   * @Date 上午 11:15 2019/4/1 0001
   * @Param [bookId]
   * @return BookCenter
   */
  public AudioBook getAudioBookById(String bookId) {
    StringBuilder reqUrl = new StringBuilder(url);
    reqUrl.append("audio/getAudioInfoList");
      Map<String,String> reqMap = new HashMap<>();
      reqMap.put("bookId", bookId);
    AudioBook book = null;
    String result = HttpUtils.postMap(reqUrl.toString(), reqMap);
    if (StringUtils.isNotBlank(result)) {
      JSONObject object = JSONObject.parseObject(result);
      int errCode = object.getInteger("errCode");
      String errMsg = object.getString("errMsg");
      if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
        JSONObject data = object.getJSONObject("data");
        if (null != data) {
          book = jsonObjectToAudioBook(data);
        }
      }
    }
    return book;
  }
  /**
   * @Author YDF
   * @Description 获取图书信息
   * @Date 上午 11:15 2019/4/1 0001
   * @Param [bookId]
   * @return BookCenter
   */
  public BookCenter getBookById(String bookId) {
    StringBuilder reqUrl = new StringBuilder(url);
    reqUrl.append("book/getBookInfo?bookId=").append(bookId);
    BookCenter book = null;
    String result = HttpUtils.sendGet(reqUrl.toString());
    if (StringUtils.isNotBlank(result)) {
      JSONObject object = JSONObject.parseObject(result);
      int errCode = object.getInteger("errCode");
      String errMsg = object.getString("errMsg");
      if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
        JSONObject data = object.getJSONObject("data");
        if (null != data) {
          book = jsonObjectToBook(data);
        }
      }
    }
    return book;
  }
  
  /**
   * @Author YDF
   * @Description 获取图书章节信息
   * @Date 下午 2:15 2019/4/1 0001
   * @Param [chapterId]
   * @return BookChapter
   **/
  public BookChapter getBookChapterById(Integer chapterId){
	  StringBuilder reqUrl = new StringBuilder(url);
	  reqUrl.append("book/getBookChapter?chapterId=").append(chapterId);
	  BookChapter bookChapter = null;
	  String result = HttpUtils.sendGet(reqUrl.toString());
	  if (StringUtils.isNotBlank(result)) {
		  JSONObject object = JSONObject.parseObject(result);
		  int errCode = object.getInteger("errCode");
		  String errMsg = object.getString("errMsg");
		  if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
			  JSONObject data = object.getJSONObject("data");
			  if (null != data) {
				  bookChapter = jsonObjectToChapter(data);
			  }
		  }
	  }
	  return bookChapter;
  }
	
	/**
	 * @Author YDF
	 * @Description 获取图书章节内容
	 * @Date 下午 2:15 2019/4/1 0001
	 * @Param [chapterId]
	 * @return BookChapter
	 **/
	public BookChapterContent getBookChapterContentById(Integer chapterId){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookChapterContent?chapterId=").append(chapterId);
		BookChapterContent chapterContent = null;
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONObject data = object.getJSONObject("data");
				if (null != data) {
					chapterContent = new BookChapterContent();
					chapterContent.setId(data.getInteger("chapterId"));
					chapterContent.setContent(data.getString("content"));
				}
			}
		}
		return chapterContent;
	}
	
	/**
	 * @Author YDF
	 * @Description 获取图书章节信息列表
	 * @Date 下午 2:15 2019/4/1 0001
	 * @Param [chapterId]
	 * @return BookChapter
	 **/
	public List<BookChapter> getBookChapterList(String bookId){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookChapterList?bookId=").append(bookId);
		List<BookChapter> chapterList = new ArrayList<>();
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONArray dataArray = object.getJSONArray("data");
				if (null != dataArray) {
					for (int i = 0; i < dataArray.size(); i++){
						JSONObject data = dataArray.getJSONObject(i);
						if (null != data){
							BookChapter bookChapter = jsonObjectToChapter(data);
							chapterList.add(bookChapter);
						}
					}
				}
			}
		}
		return chapterList;
	}
	
	/**
	 * @Author YDF
	 * @Description 获取图书信息列表
	 * @Date 下午 3:14 2019/4/1 0001
	 * @Param [pageIndex, pageSize]
	 * @return java.util.List<BookCenter>
	 **/
	public List<BookCenter> getBookList(Integer pageIndex, Integer pageSize){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookInfoList?pageIndex=").append(pageIndex);
		reqUrl.append("&pageSize=").append(pageSize);
		List<BookCenter> bookList = new ArrayList<>();
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONObject data = object.getJSONObject("data");
				if (null != data){
					JSONArray listArray = data.getJSONArray("list");
					if (null != listArray) {
						for (int i = 0; i < listArray.size(); i++){
							JSONObject list = listArray.getJSONObject(i);
							if (null != list){
								BookCenter book = jsonObjectToBook(list);
								bookList.add(book);
							}
						}
					}
				}
			}
		}
		return bookList;
	}
	
	/**
	 * @Author YDF
	 * @Description 获取图书卷信息
	 * @Date 下午 4:28 2019/4/1 0001
	 * @Param [volumeId]
	 * @return BookVolume
	 **/
	public BookVolume getBookVolumeById(Integer volumeId){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookVolume?volumeId=").append(volumeId);
		BookVolume bookVolume = null;
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONObject data = object.getJSONObject("data");
				if (null != data) {
					bookVolume = jsonObjectToVolume(data);
				}
			}
		}
		return bookVolume;
	}
	
	/**
	 * @Author YDF
	 * @Description 获取图书卷信息列表
	 * @Date 下午 4:39 2019/4/1 0001
	 * @Param [bookId]
	 * @return java.util.List<BookVolume>
	 **/
	public List<BookVolume> getBookVolumeList(String bookId){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookVolumeList?bookId=").append(bookId);
		List<BookVolume> volumeList = new ArrayList<>();
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONArray dataArray = object.getJSONArray("data");
				if (null != dataArray) {
					for (int i = 0; i < dataArray.size(); i++){
						JSONObject data = dataArray.getJSONObject(i);
						if (null != data){
							BookVolume bookVolume = jsonObjectToVolume(data);
							volumeList.add(bookVolume);
						}
					}
				}
			}
		}
		return volumeList;
	}
	
	/**
	 * @Author YDF
	 * @Description 获取图书分类信息
	 * @Date 下午 3:58 2019/4/11 0011
	 * @Param [categoryId]
	 */
	public BookCategory getBookCategory(Integer categoryId){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookCategory?categoryId=").append(categoryId);
		BookCategory bookCategory = null;
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONObject data = object.getJSONObject("data");
				if (null != data) {
					bookCategory = jsonObjectToCategory(data);
				}
			}
		}
		return bookCategory;
	}
	
	/**
	 * @Author YDF
	 * @Description 获取图书分类信息列表
	 * @Date 下午 4:57 2019/4/11 0011
	 * @Param [pindaoId]
	 * @return java.util.List<com.iwanvi.freebook.bookcenter.pojo.BookCategory>
	 */
	public List<BookCategory> getBookCategoryList(String pindaoId){
		StringBuilder reqUrl = new StringBuilder(url);
		reqUrl.append("book/getBookCategoryList?bookId=").append(pindaoId);
		List<BookCategory> categoryList = new ArrayList<>();
		String result = HttpUtils.sendGet(reqUrl.toString());
		if (StringUtils.isNotBlank(result)) {
			JSONObject object = JSONObject.parseObject(result);
			int errCode = object.getInteger("errCode");
			String errMsg = object.getString("errMsg");
			if (0 == errCode && Constants.RETURN_CODE_OK.equals(errMsg)) {
				JSONArray dataArray = object.getJSONArray("data");
				if (null != dataArray) {
					for (int i = 0; i < dataArray.size(); i++){
						JSONObject data = dataArray.getJSONObject(i);
						if (null != data){
							BookCategory bookCategory = jsonObjectToCategory(data);
							categoryList.add(bookCategory);
						}
					}
				}
			}
		}
		return categoryList;
	}
	
	/**
	 * @Author YDF
	 * @Description JSONObject 转换图书类型
	 * @Date 下午 3:59 2019/4/11 0011
	 * @Param [data]
	 * @return com.iwanvi.freebook.bookcenter.pojo.BookCategory
	 */
	private BookCategory jsonObjectToCategory(JSONObject data) {
		BookCategory bookCategory = new BookCategory();
		bookCategory.setId(data.getInteger("id"));
		bookCategory.setName(data.getString("name"));
		bookCategory.setAuthorCategory(data.getString("authorCategoryName"));
		return bookCategory;
	}
	
	/**
	 * @Author YDF
	 * @Description JSONObject 转卷
	 * @Date 下午 4:30 2019/4/1 0001
	 * @Param [data]
	 * @return BookVolume
	 **/
	private BookVolume jsonObjectToVolume(JSONObject data){
		BookVolume bookVolume = new BookVolume();
		bookVolume.setId(data.getInteger("volumeId"));
		bookVolume.setBookId(data.getString("bookId"));
		bookVolume.setName(data.getString("volumeName"));
		bookVolume.setIdx(data.getInteger("volumeIndex"));
		return bookVolume;
	}
	
	/**
	 * @Author YDF
	 * @Description JSONObject 转章节
	 * @Date 下午 2:46 2019/4/1 0001
	 * @Param [data]
	 * @return BookChapter
	 **/
	private BookChapter jsonObjectToChapter(JSONObject data){
		BookChapter bookChapter = new BookChapter();
		bookChapter.setId(data.getInteger("chapterId"));
		bookChapter.setBookid(data.getString("bookId"));
		bookChapter.setVolumeId(data.getInteger("volumeId"));
		bookChapter.setName(data.getString("chapterName"));
		bookChapter.setIdx(data.getInteger("chapterIndex"));
		bookChapter.setWordCount(data.getInteger("wordCount"));
		bookChapter.setIsvip(data.getString("isVip"));
		bookChapter.setStatus(data.getInteger("status"));
		bookChapter.setCreateDate(DateUtils.strToDateTime(data.getString("createDate")));
		bookChapter.setUpdateDate(DateUtils.strToDateTime(data.getString("updateDate")));
		return bookChapter;
	}
	
	/**
	 * @Author YDF
	 * @Description JSONObject 转图书
	 * @Date 下午 3:06 2019/4/1 0001
	 * @Param [data]
	 * @return BookCenter
	 **/
	public static BookCenter jsonObjectToBook(JSONObject data){
		BookCenter book = new BookCenter();
		book.setBookId(data.getString("bookId"));
		book.setBookName(data.getString("bookName"));
		book.setBookAuthor(data.getString("authorName"));
		book.setIntroduction(data.getString("introduction"));
		book.setImgUrl(data.getString("imageUrl"));
		book.setWordCount(data.getInteger("wordCount"));
		book.setCategoryId(data.getInteger("categoryId"));
		book.setCategorySec(data.getInteger("categorySecId"));
		book.setCategoryThr(data.getInteger("categoryThrId"));
		book.setKeyWord(data.getString("keyword"));
		book.setStatus(data.getInteger("status"));
		book.setBookStatus(data.getString("bookStatus"));
		book.setCreateDate(DateUtils.strToDateTime(data.getString("createDate")));
		book.setUpdateDate(DateUtils.strToDateTime(data.getString("updateDate")));
		book.setLastUpdateChapterId(data.getInteger("lastUpdateChapterId"));
		book.setLastUpdateChapterName(data.getString("lastUpdateChapterName"));
		book.setLastUpdateChapterDate(DateUtils.strToDateTime(data.getString("lastUpdateChapterDate")));
		book.setPindaoId(data.getInteger("pindaoId"));
		book.setChapterCount(data.getInteger("chapterCount"));
		return book;
	}
	
	/**
	 * @Author YDF
	 * @Description JSONObject 转有声图书
	 * @Date 2019-6-17 14:48:27
	 * @Param [data]
	 * @return AudioBook
	 **/
	public static AudioBook jsonObjectToAudioBook(JSONObject data){
		AudioBook book = new AudioBook();
		book.setBookId(data.getString("bookId"));
		book.setTitle(data.getString("title"));
		book.setImgUrl(data.getString("imageUrl"));
		book.setAudioTime(data.getInteger("audioTime"));
		book.setAuthorName(data.getString("authorName"));
		book.setStatus(data.getInteger("status"));
		book.setCreateDate(DateUtils.strToDateTime(data.getString("createDate")));
		book.setUpdateDate(DateUtils.strToDateTime(data.getString("updateDate")));
		book.setSysCreateDate(DateUtils.strToDateTime(data.getString("sysCreateDate")));
		book.setSysUpdateDate(DateUtils.strToDateTime(data.getString("sysUpdateDate")));
		book.setAudioStatus(data.getInteger("audioStatus"));
		book.setCpId(null == data.getInteger("cpAudioId") ?"":String.valueOf(data.getInteger("cpAudioId")));
		book.setLastUpdateChapterId(data.getInteger("lastUpdateChapterId"));
		book.setLastUpdateChapterName(data.getString("lastUpdateChapterName"));
		book.setLastUpdateChapterDate(DateUtils.strToDateTime(data.getString("lastUpdateChapterDate")));
		book.setCategoryId(null == data.getInteger("categoryId")?null:Long.valueOf(data.getInteger("categoryId")));
		book.setLecturer(data.getString("lecturer"));
		book.setIntroduction(data.getString("introduction"));
		book.setShortIntroduction(data.getString("shortIntroduction"));
		book.setSecondCategoryId(data.getInteger("secondCategoryId"));
		book.setFirstCategoryId(data.getInteger("firstCategoryId"));
		book.setLongImgUrl(data.getString("longImgUrl"));
		book.setKeyword(data.getString("keyword"));
		book.setLecturerIntroduction(data.getString("lecturerIntroduction"));
		book.setTotalSize(data.getLong("totalSize"));
		book.setTotalTime(data.getInteger("totalTime"));
		book.setTotalChapter(data.getInteger("totalChapter"));
		return book;
	}
	
	

  public static void main(String[] args) {
	  String bookId = "121053";
	  int chapterId = 14757;
	  int volumeId = 324;
	  getBook(bookId);
	  getBookChapter(chapterId);
	  getBookChapterContent(chapterId);
	  getChapterList(bookId);
	  getBookCenterList();
	  getBookVolume(volumeId);
	  getBolumeList(bookId);
  }
	/**
	 * @Author YDF
	 * @Description 卷列表
	 * @Date 下午 4:45 2019/4/1 0001
	 * @Param [bookId]
	 * @return void
	 **/
	private static void getBolumeList(String bookId){
		BaseUtil util = new BaseUtil();
		List<BookVolume> volumeList = util.getBookVolumeList(bookId);
		if (null != volumeList && !volumeList.isEmpty()){
			for (BookVolume volume : volumeList){
				System.out.println(volume.getName());
			}
		}
	}
 
	/**
	 * @Author YDF
	 * @Description 卷
	 * @Date 下午 4:45 2019/4/1 0001
	 * @Param [volumeId]
	 * @return void
	 **/
  private static void getBookVolume(Integer volumeId){
	  BaseUtil util = new BaseUtil();
	  BookVolume bookVolume = util.getBookVolumeById(volumeId);
	  System.out.println("getBookVolume==id="+bookVolume.getId()+",idx="+bookVolume.getIdx()+",name="+bookVolume.getName()+",bookId="+bookVolume.getBookId());
	  System.out.println(bookVolume.getIdx());
  }
  
  /**
   * @Author YDF
   * @Description 图书列表
   * @Date 下午 4:45 2019/4/1 0001
   * @Param []
   * @return void
   **/
	private static void getBookCenterList(){
		BaseUtil util = new BaseUtil();
		List<BookCenter> bookList = util.getBookList(1,10);
		if (null != bookList && !bookList.isEmpty()){
			for (BookCenter book : bookList){
				System.out.println(book.getBookName());
			}
		}
	}
 
	/**
	 * @Author YDF
	 * @Description 章节列表
	 * @Date 下午 4:45 2019/4/1 0001
	 * @Param [bookId]
	 * @return void
	 **/
  	private static void getChapterList(String bookId){
	  BaseUtil util = new BaseUtil();
	  List<BookChapter> chapterList = util.getBookChapterList(bookId);
	  if (null != chapterList && !chapterList.isEmpty()){
	  	for (BookChapter bookChapter : chapterList){
        	System.out.println(bookChapter.getName());
		}
	  }
  }
	
	/**
	 * @Author YDF
	 * @Description 章节内容
	 * @Date 下午 2:14 2019/4/1 0001
	 * @Param []
	 * @return void
	 **/
	private static void getBookChapterContent(Integer chapterId){
		BaseUtil util = new BaseUtil();
		BookChapterContent chapter = util.getBookChapterContentById(chapterId);
		System.out.println("getBookChapterContent==id="+chapter.getId()+",content="+chapter.getContent());
	}
 
	/**
	 * @Author YDF
	 * @Description 图书信息
	 * @Date 下午 2:14 2019/4/1 0001
	 * @Param []
	 * @return void
	 **/
	private static void getBookChapter(Integer chapterId){
		BaseUtil util = new BaseUtil();
		BookChapter chapter = util.getBookChapterById(chapterId);
		System.out.println("getBookChapter==id="+chapter.getId()+",name="+chapter.getName()+",idx="+chapter.getIdx()+",bookId="+chapter.getBookid());
	}
  
  /**
   * @Author YDF
   * @Description 图书信息
   * @Date 下午 2:14 2019/4/1 0001
   * @Param []
   * @return void
   **/
  private static void getBook(String bookId){
	  BaseUtil util = new BaseUtil();
	  BookCenter bookCenter = util.getBookById(bookId);
	  System.out.println("getBook==bookId="+bookCenter.getBookId()+",bookName="+bookCenter.getBookName()+",wordCount="+bookCenter.getWordCount()+",createDate="+bookCenter.getCreateDate());
  }
}
