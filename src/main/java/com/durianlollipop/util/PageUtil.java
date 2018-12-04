package com.durianlollipop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.durianlollipop.Queue.MyQueue;
import com.durianlollipop.pojo.Page;

/**
 * 页面工具类
 * @author 15914
 *
 */
public class PageUtil {
	
	public PageUtil() {}
	
	private static MyQueue myQueue;
	
	/**
	 * 封装页面信息
	 * 状态值
	 * 包含的url
	 * 页面类型content-type
	 * @param response
	 * @return Page对象
	 */
	public static Page getPageInfo(CloseableHttpResponse response) {
		Page page = new Page();
		
		int requeststatus = response.getStatusLine().getStatusCode();
		String contentType = response.getFirstHeader("Content-Type").getValue();
		
		page.setRequeststatus(requeststatus);
		page.setContentType(contentType);
		try {
			if(page.getType().equals("text/html")) {
				List<String> urlList = new ArrayList<>();
				HttpEntity entity = response.getEntity();
					String html = EntityUtils.toString(entity);
					Document document = Jsoup.parse(html);
					Element body = document.body();
					Elements label_a = body.select("a");
					for (Element a : label_a) {
						String url = a.attr("href");
						if(url.equals("../")) {
							continue;
						}
						urlList.add(url);
					}
					page.setUrlList(urlList);
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		
		return page;
	}
}
