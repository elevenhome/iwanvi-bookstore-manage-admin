package com.iwanvi.bookstore.admin.common.util;

import com.alibaba.fastjson.JSONObject;
import com.iwanvi.bookstore.admin.common.config.RuoYiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author YDF
 * @Description 获取地址类
 * @Date 2019/3/12 0012 10:44
 * @Version 1.0
 **/
public class AddressUtils {
	private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);
	
	public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";
	
	public static String getRealAddressByIP(String ip) {
		String address = "XX XX";
		// 内网不查询
		if (IpUtils.internalIp(ip)) {
			return "内网IP";
		}
		if (RuoYiConfig.isAddressEnabled()) {
			String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
			if (StringUtils.isEmpty(rspStr)) {
				log.error("获取地理位置异常 {}", ip);
				return address;
			}
			JSONObject obj = JSONObject.parseObject(rspStr);
			JSONObject data = obj.getObject("data", JSONObject.class);
			String region = data.getString("region");
			String city = data.getString("city");
			address = region + " " + city;
		}
		return address;
	}
}
