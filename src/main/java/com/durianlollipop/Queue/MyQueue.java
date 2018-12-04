package com.durianlollipop.Queue;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.durianlollipop.pojo.Page;

@Component
public class MyQueue {
	
	public MyQueue() {
		System.out.println("MyQueue");
	}
	
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
