/**
 * 
 */
package com.lostvip.app.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author songsz
 * 
 */
public class HttpClientUtil {
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	// 请求超时时间,这个时间定义了socket读数据的超时时间，也就是连接到服务器之后到从服务器获取响应数据需要等待的时间,发生超时，会抛出SocketTimeoutException异常。
	private static final int SOCKET_TIME_OUT = 60000;
	// 连接超时时间,这个时间定义了通过网络与服务器建立连接的超时时间，也就是取得了连接池中的某个连接之后到接通目标url的连接等待时间。发生超时，会抛出ConnectionTimeoutException异常
	private static final int CONNECT_TIME_OUT = 60000;
	public static String doctorId;
    public static String token;
    public static String version;
    public static String appId;
    public static String sign;
    public static String signType;
	public static String post(Object obj,String url) {
		String json = JsonUtil.objectToJson(obj);
		return post(json, url);
	}
	
	public static String post(String json,String url) {
		String resData = null;
		logger.info(">>>>>>>>" + json);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost method = new HttpPost(url);
		RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIME_OUT)
				.setConnectTimeout(CONNECT_TIME_OUT).build();
		method.setConfig(reqConfig);
		method.addHeader("token", token);
		method.addHeader("doctorId", doctorId);
		method.addHeader("version", version);
		method.addHeader("appId", appId);
		method.addHeader("sign", sign);
		method.addHeader("signType",signType);
		StringEntity entity;
		try {
			entity = new StringEntity(json, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			method.setEntity(entity);
			HttpResponse result = httpClient.execute(method);
			// 请求结束，返回结果
			resData = EntityUtils.toString(result.getEntity());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 解决中文乱码问题
		logger.info("<<<<<<<<" + resData);
		return resData;
	}
	
	public static String get(String url) {
		String resData = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		logger.info("<<<<<<<" + url);
		HttpGet method = new HttpGet(url);
		RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIME_OUT)
				.setConnectTimeout(CONNECT_TIME_OUT).build();
		method.setConfig(reqConfig);
		
		method.addHeader("token", token);
		method.addHeader("doctorId", doctorId);
		method.addHeader("version", version);
		method.addHeader("appId", appId);
		method.addHeader("sign", sign);
		StringEntity entity;
		try {
			HttpResponse result = httpClient.execute(method);
			// 请求结束，返回结果
			resData = EntityUtils.toString(result.getEntity());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 解决中文乱码问题
		logger.info("<<<<<<" + resData);
		return resData;
	}
	
	public static String postForm(String url, Map<String, Object> params) {
		return postForm(url, params,null);
	}
	
	public static String postForm(String url, Map<String, Object> param, Map<String, Object> headers) {
		// 目前HttpClient最新版的实现类为CloseableHttpClient
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		try {
			if (param != null) {
				// 建立Request的对象，一般用目标url来构造，Request一般配置addHeader、setEntity、setConfig
				HttpPost req = new HttpPost(url);
				entity = new UrlEncodedFormEntity(createParam(param), Consts.UTF_8);
				// setHeader,添加头文件
				if(headers!=null && !headers.isEmpty()){
					Set<String> keys = headers.keySet();
					for (String key : keys) {
						req.setHeader(key, headers.get(key).toString());
					}
				}
				
				// setConfig,添加配置,如设置请求超时时间,连接超时时间
				RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIME_OUT).setConnectTimeout(CONNECT_TIME_OUT).build();
				req.setConfig(reqConfig);
				// setEntity,添加内容
				req.setEntity(entity);
				// 执行Request请求,CloseableHttpClient的execute方法返回的response都是CloseableHttpResponse类型
				// 其常用方法有getFirstHeader(String)、getLastHeader(String)、headerIterator（String）取得某个Header
				// name对应的迭代器、getAllHeaders()、getEntity、getStatus等
				response = client.execute(req);
				entity = response.getEntity();
				// 用EntityUtils.toString()这个静态方法将HttpEntity转换成字符串,防止服务器返回的数据带有中文,所以在转换的时候将字符集指定成utf-8就可以了
				String result = EntityUtils.toString(entity, "UTF-8");
				System.out.println("-------------------------" + result + "-------------");
				if (response.getStatusLine().getStatusCode() == 200) {
					System.out.println(result + "-----------success------------------");
					return result;
				} else {
					System.out.println(response.getStatusLine().getStatusCode() + "------------------fail-----------");
					return null;
				}
			}
			return null;
		} catch (Exception e) {
			System.out.println("--------------------------post error: " + e);
		} finally {
			// 一定要记得把entity fully consume掉，否则连接池中的connection就会一直处于占用状态
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("---------------------------finally-------------");
		}
		return null;
	}

	private static List<NameValuePair> createParam(Map<String, Object> param) {
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (param != null) {
			for (String k : param.keySet()) {
				nvps.add(new BasicNameValuePair(k, param.get(k).toString()));
			}
		}
		return nvps;
	}
}
