package com.durianlollipop.Queue;

import java.util.Vector;

public class UrlQueue {

	private Vector<String> vector = new Vector<>();

	public String getUrl() {
		return vector.remove(0);
	}
	
	public void setUrl(String url) {
		vector.add(url);
	}

	public int size() {
		return vector.size();
	}
}
