package com.iwanvi.bookstore.admin.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author YDF
 * @Description 时间工具类
 * @Date 2019/3/12 0012 9:58
 * @Version 1.0
 **/
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	public static String YYYY = "yyyy";
	public static String YYYY_MM = "yyyy-MM";
	public static String YYYY_MM_DD = "yyyy-MM-dd";
	public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	private static String[] parsePatterns = {
			"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
			"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
	
	/**
	 * 获取当前Date型日期
	 *
	 * @return Date() 当前日期
	 */
	public static Date getNowDate() {
		return new Date();
	}
	
	/**
	 * 获取当前日期, 默认格式为yyyy-MM-dd
	 *
	 * @return String
	 */
	public static String getDate() {
		return dateTimeNow(YYYY_MM_DD);
	}
	
	public static final String getTime() {
		return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
	}
	
	public static final String dateTimeNow() {
		return dateTimeNow(YYYYMMDDHHMMSS);
	}
	
	public static final String dateTimeNow(final String format) {
		return parseDateToStr(format, new Date());
	}
	
	public static final String dateTime(final Date date) {
		return parseDateToStr(YYYY_MM_DD, date);
	}
	
	public static final String parseDateToStr(final String format, final Date date) {
		return new SimpleDateFormat(format).format(date);
	}
	
	public static final Date dateTime(final String format, final String ts) {
		try {
			return new SimpleDateFormat(format).parse(ts);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 日期路径 即年/月/日 如2018/08/08
	 */
	public static final String datePath() {
		Date now = new Date();
		return DateFormatUtils.format(now, "yyyy/MM/dd");
	}
	
	/**
	 * 日期路径 即年/月/日 如20180808
	 */
	public static final String dateTime() {
		Date now = new Date();
		return DateFormatUtils.format(now, "yyyyMMdd");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * @Author YDF
	 * @Description 日期字符串转日期
	 * @Date 14:24 2019/1/7 0007
	 * @Param [str]
	 * @return java.util.Date
	 **/
	public static Date strToDateTime(String str){
		if (null == str || "".equals(str)){
			return null;
		}
		SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			if (str.length() == 10) {
				str += " 00:00:00";
			}
			return YMDHMS_FORMAT.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取服务器启动时间
	 */
	public static Date getServerStartDate() {
		long time = ManagementFactory.getRuntimeMXBean().getStartTime();
		return new Date(time);
	}
	
	/**
	 * 计算两个时间差
	 */
	public static String getDatePoor(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		// long sec = diff % nd % nh % nm / ns;
		return day + "天" + hour + "小时" + min + "分钟";
	}

	/**
	 * 获得指定日期的前一天
	 * @param specifiedDay
	 * @return yyyy-MM-dd
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		try {
			date = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(c.getTime());
		return dayBefore;
	}

	/**
	 * 得到当前时间的前N小时
	 * @param ihour
	 * @return
	 */
	public static String getBeforeByHourTime(int ihour){
		String returnstr = "";
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);  
		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS); 
		returnstr = df.format(calendar.getTime());  
		return returnstr; 
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate 较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate){
		SimpleDateFormat YMD_FORMAT = new SimpleDateFormat(YYYY_MM_DD);
		try {
			smdate = YMD_FORMAT.parse(YMD_FORMAT.format(smdate));
			bdate = YMD_FORMAT.parse(YMD_FORMAT.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
	  String yestDay = getSpecifiedDayBefore(getTime());
	  System.out.println(yestDay);
    System.out.println(getBeforeByHourTime(1));
  }
}
