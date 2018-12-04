package com.durianlollipop.ftp.downloadfile;


import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durianlollipop.crawler.HttpClient;
import com.durianlollipop.util.BaseUtil;

public class TestDownload {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpClient httpClient = context.getBean(HttpClient.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入网址:");
		String url = sc.nextLine();
		System.out.println("请输入用户名:");
		String username = sc.nextLine();
		System.out.println("请输入密码:");
		String password = sc.nextLine();
		String authorization = BaseUtil.getAuthorization(username, password);
		httpClient.getPage(url, authorization);
	}
	
}
