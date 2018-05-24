package com.ls.nssh.common;

import java.util.List;

public class PageData<T>{
	private List<T> list;//每页显示数据的集合
	private int total;
	
	public PageData() {
		super();
	}
	public PageData(List<T> list, int total) {
		super();
		this.list = list;
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
    
}
