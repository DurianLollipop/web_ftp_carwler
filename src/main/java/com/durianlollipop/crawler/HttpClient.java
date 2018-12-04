package com.durianlollipop.crawler;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.durianlollipop.Queue.MyQueue;
import com.durianlollipop.util.PageUtil;

public class HttpClient {
	
	HttpGet httpGet = new HttpGet(); 
	
	private MyQueue myQueue;
	
	
	public MyQueue getMyQueue() {
		return myQueue;
	}

	public void setMyQueue(MyQueue myQueue) {
		this.myQueue = myQueue;
	}
	
	/**
	 * 获取page信息
	 * @param url 请求url
	 * @param authorization	用户身份认证信息
	 * @return
	 */
	public String getPage(String url,String authorization){
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(url);
			request.setHeader("Authorization","Basic "+ authorization);
			CloseableHttpResponse response = client.execute(request);
			PageUtil.getPageInfo(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
