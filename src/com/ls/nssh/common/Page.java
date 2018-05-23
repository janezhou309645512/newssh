package com.ls.nssh.common;
/**
 * 
 * 分页处理的类
 * @author janezhou
 *
 */

public class Page {
	private int pageNumber;//
	private int pageSize;
	
	public Page() {
		super();
	}
	public Page(int pageNumber, int pageSize) {
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
	
	
	
	
	

}
