package com.durianlollipop.pojo;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private int Requeststatus;
	private String ContentType;
	private List<String> urlList = new ArrayList<>();

	public int getRequeststatus() {
		return Requeststatus;
	}

	public void setRequeststatus(int requeststatus) {
		Requeststatus = requeststatus;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	@Override
	public String toString() {
		return "Page [Requeststatus=" + Requeststatus + ", ContentType=" + ContentType + ", urlList=" + urlList + "]";
	}

}
