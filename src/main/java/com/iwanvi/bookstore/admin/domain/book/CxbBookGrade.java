package com.iwanvi.bookstore.admin.domain.book;

import com.iwanvi.bookstore.admin.domain.BaseEntity;

public class CxbBookGrade extends BaseEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 图书ID
     */
    private String bookId;

    /**
     * 月PV
     */
    private Long monthPv;

    /**
     * 周PV
     */
    private Long weekPv;

    /**
     * 
     */
    private Long readOverPv;

    /**
     * 
     */
    private Long downloadPv;

    /**
     * 
     */
    private Long sharePv;

    /**
     * 
     */
    private Long sevenclick;

    /**
     * 
     */
    private Long searchtodetails;

    /**
     * 
     */
    private Long lastweek;

    /**
     * 
     */
    private Long readnum;

    /**
     * 日期
     */
    private String cdt;

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
     * 图书ID
     * @return book_id 图书ID
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * 图书ID
     * @param bookId 图书ID
     */
    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    /**
     * 
     * @return month_pv 
     */
    public Long getMonthPv() {
        return monthPv;
    }

    /**
     * 
     * @param monthPv 
     */
    public void setMonthPv(Long monthPv) {
        this.monthPv = monthPv;
    }

    /**
     * 
     * @return week_pv 
     */
    public Long getWeekPv() {
        return weekPv;
    }

    /**
     * 
     * @param weekPv 
     */
    public void setWeekPv(Long weekPv) {
        this.weekPv = weekPv;
    }

    /**
     * 
     * @return read_over_pv 
     */
    public Long getReadOverPv() {
        return readOverPv;
    }

    /**
     * 
     * @param readOverPv 
     */
    public void setReadOverPv(Long readOverPv) {
        this.readOverPv = readOverPv;
    }

    /**
     * 
     * @return download_pv 
     */
    public Long getDownloadPv() {
        return downloadPv;
    }

    /**
     * 
     * @param downloadPv 
     */
    public void setDownloadPv(Long downloadPv) {
        this.downloadPv = downloadPv;
    }

    /**
     * 
     * @return share_pv 
     */
    public Long getSharePv() {
        return sharePv;
    }

    /**
     * 
     * @param sharePv 
     */
    public void setSharePv(Long sharePv) {
        this.sharePv = sharePv;
    }

    /**
     * 
     * @return sevenClick 
     */
    public Long getSevenclick() {
        return sevenclick;
    }

    /**
     * 
     * @param sevenclick 
     */
    public void setSevenclick(Long sevenclick) {
        this.sevenclick = sevenclick;
    }

    /**
     * 
     * @return searchTodetails 
     */
    public Long getSearchtodetails() {
        return searchtodetails;
    }

    /**
     * 
     * @param searchtodetails 
     */
    public void setSearchtodetails(Long searchtodetails) {
        this.searchtodetails = searchtodetails;
    }

    /**
     * 
     * @return lastWeek 
     */
    public Long getLastweek() {
        return lastweek;
    }

    /**
     * 
     * @param lastweek 
     */
    public void setLastweek(Long lastweek) {
        this.lastweek = lastweek;
    }

    /**
     * 
     * @return readNum 
     */
    public Long getReadnum() {
        return readnum;
    }

    /**
     * 
     * @param readnum 
     */
    public void setReadnum(Long readnum) {
        this.readnum = readnum;
    }

    /**
     * 日期
     * @return cdt 日期
     */
    public String getCdt() {
        return cdt;
    }

    /**
     * 日期
     * @param cdt 日期
     */
    public void setCdt(String cdt) {
        this.cdt = cdt == null ? null : cdt.trim();
    }
}