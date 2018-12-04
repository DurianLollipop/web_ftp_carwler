package com.durianlollipop.Queue;

import java.util.LinkedList;
import com.durianlollipop.pojo.Page;

public class MyQueue {
	
	private LinkedList<Page> pageList = new LinkedList<>();
	
	public Page getPage(){
		return pageList.removeFirst();
	}
	
	public void setPage(Page page){
		pageList.add(page);
	}
	
	public int size() {
		return pageList.size();
	}
	
}
