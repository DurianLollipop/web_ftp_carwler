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

import com.durianlollipop.pojo.Page;

public class PageUtil {
	
	public PageUtil() {}
	
	public static Page getPageInfo(CloseableHttpResponse response) {
		Page page = new Page();
		
		int requeststatus = response.getStatusLine().getStatusCode();
		String contentType = response.getFirstHeader("Content-Type").getValue();
		
		page.setRequeststatus(requeststatus);
		page.setContentType(contentType);
		List<String> urlList = new ArrayList<>();
		HttpEntity entity = response.getEntity();
		try {
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
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(page);
		return page;
	}
}
