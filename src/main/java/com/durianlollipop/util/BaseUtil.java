package com.durianlollipop.util;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

/**
 * 基本工具类
 * 
 * @author 15914
 *
 */
public class BaseUtil {

	private BaseUtil() {}

	/**
	 * 通过用户名密码得到Authorization加密值
	 * @param username
	 * @param password
	 * @return
	 */
	public static String getAuthorization(String username,String password) {
		try {
			username = username.trim();
			password = password.trim();
			// username:password--->访问的用户名，密码,并使用base64进行加密，将加密的字节信息转化为string类型，encoding--->token
			return DatatypeConverter.printBase64Binary((username+":"+password).getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//public static 
}
