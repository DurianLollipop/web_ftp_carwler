package com.durianlollipop.Queue;

import java.util.LinkedList;

import com.durianlollipop.pojo.Page;

public class MyQueue {
	
	public MyQueue() {
		System.out.println("MyQueue");
	}
	
	private LinkedList<Page> pageList = new LinkedList<>();
	
	public Page getPage(){
		return pageList.getFirst();
	}
	
	public void setPage(Page page){
		pageList.add(page);
	}
	
}
