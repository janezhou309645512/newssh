package com.ls.nssh.common;

import java.util.List;
/**
 * 输出的显示数据
 * @author janezhou
 *
 * @param <T>
 */

public class PageOut<T>{
	private List<T> list;//每页显示数据的集合
	private int total;
	
	public PageOut() {
		super();
	}
	public PageOut(List<T> list, int total) {
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
