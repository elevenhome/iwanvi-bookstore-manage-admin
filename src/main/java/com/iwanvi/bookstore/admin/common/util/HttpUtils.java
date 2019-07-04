package com.iwanvi.bookstore.admin.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author YDF
 * @Description 通用http发送方法
 * @Date 2019/3/12 0012 10:16
 * @Version 1.0
 **/
public class HttpUtils {
	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
	
	private static URLConnection getConnection(String url) throws Exception{
		URL realUrl = new URL(url);
		// 打开和URL之间的连接
		URLConnection connection = realUrl.openConnection();
		// 设置通用的请求属性
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		//建立实际的连接
		connection.connect();
		return connection;
	}
	
	/**
	 * 向指定URL发送GET方法的请求
	 * @param url 发送请求的URL
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url) {
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;
		try {
			//定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(getConnection(url).getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result.toString();
	}
	
	/**
	 * 向指定 URL 发送GET方法的请求
	 *
	 * @param url   发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			log.info("sendGet - {}", urlNameString);
			in = new BufferedReader(new InputStreamReader(getConnection(url).getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			log.info("recv - {}", result);
		} catch (ConnectException e) {
			log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
		} catch (SocketTimeoutException e) {
			log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
		} catch (IOException e) {
			log.error("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
		} catch (Exception e) {
			log.error("调用HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception ex) {
				log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
			}
		}
		return result.toString();
	}
	
	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url   发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			String urlNameString = url + "?" + param;
			log.info("sendPost - {}", urlNameString);
			URLConnection conn = getConnection(url);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			log.info("recv - {}", result);
		} catch (ConnectException e) {
			log.error("调用HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
		} catch (SocketTimeoutException e) {
			log.error("调用HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
		} catch (IOException e) {
			log.error("调用HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
		} catch (Exception e) {
			log.error("调用HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
			}
		}
		return result.toString();
	}
	
	public static String sendSSLPost(String url, String param) {
		StringBuilder result = new StringBuilder();
		String urlNameString = url + "?" + param;
		try {
			log.info("sendSSLPost - {}", urlNameString);
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
			URL console = new URL(urlNameString);
			HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.connect();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String ret = "";
			while ((ret = br.readLine()) != null) {
				if (ret != null && !ret.trim().equals("")) {
					result.append(new String(ret.getBytes("ISO-8859-1"), "utf-8"));
				}
			}
			log.info("recv - {}", result);
			conn.disconnect();
			br.close();
		} catch (ConnectException e) {
			log.error("调用HttpUtils.sendSSLPost ConnectException, url=" + url + ",param=" + param, e);
		} catch (SocketTimeoutException e) {
			log.error("调用HttpUtils.sendSSLPost SocketTimeoutException, url=" + url + ",param=" + param, e);
		} catch (IOException e) {
			log.error("调用HttpUtils.sendSSLPost IOException, url=" + url + ",param=" + param, e);
		} catch (Exception e) {
			log.error("调用HttpsUtil.sendSSLPost Exception, url=" + url + ",param=" + param, e);
		}
		return result.toString();
	}
	
	private static class TrustAnyTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) {
		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) {
		}
		
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[]{};
		}
	}
	
	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	/**
	 * 发送post请求，参数用map接收
	 * @param url 地址
	 * @param map 参数
	 * @return 返回值
	 */
	public static String postMap(String url, Map<String,String> map) {
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for(Map.Entry<String,String> entry : map.entrySet())
		{
			pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		}
		CloseableHttpResponse response = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
			response = httpClient.execute(post);
			if(response != null && response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity entity = response.getEntity();
				result = entityToString(entity);
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				httpClient.close();
				if(response != null)
				{
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static String entityToString(HttpEntity entity) throws IOException {
		String result = null;
		if(entity != null){
			long lenth = entity.getContentLength();
			if(lenth != -1 && lenth < 2048){
				result = EntityUtils.toString(entity,"UTF-8");
			}else {
				InputStreamReader reader = new InputStreamReader(entity.getContent(), "UTF-8");
				CharArrayBuffer buffer = new CharArrayBuffer(2048);
				char[] tmp = new char[1024];
				int l;
				while((l = reader.read(tmp)) != -1) {
					buffer.append(tmp, 0, l);
				}
				result = buffer.toString();
				reader.close();
			}
		}
		return result;
	}
}