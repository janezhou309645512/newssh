package com.ls.nssh.common;

import java.util.Date;

/**
 * 
 * 分页处理的类
 * @author janezhou
 *
 */

public class PageIn<T> {
	private int pageNumber;//
	private int pageSize;
	private String startTime;
	private String endTime;
	private T t;
	
	
	public PageIn() {
		super();
	}
	public PageIn(int pageNumber, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	
	
	
	

}
