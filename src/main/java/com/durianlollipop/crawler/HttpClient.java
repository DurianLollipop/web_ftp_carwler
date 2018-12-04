package com.durianlollipop.crawler;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.durianlollipop.Queue.MyQueue;
import com.durianlollipop.pojo.Page;
import com.durianlollipop.util.PageUtil;

@Component
public class HttpClient {
	
	public HttpClient() {
		System.out.println("HttpClient.HttpClient()");
	}
	
	HttpGet httpGet = new HttpGet(); 
	
	@Autowired
	private MyQueue myQueue;

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
			Page page = PageUtil.getPageInfo(response);
			String urlSuffix = url.substring(url.lastIndexOf("."));
			System.out.println(urlSuffix);
			if(urlSuffix.equals(".htm")||!page.getType().equals("text/html")) {
				String uri = url;
				System.out.println("网页或者是文件:"+uri);
				
			}
			myQueue.setPage(page);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
