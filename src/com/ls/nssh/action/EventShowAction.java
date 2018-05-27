package com.ls.nssh.action;


import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ls.nssh.common.PageIn;
import com.ls.nssh.common.PageOut;
import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.service.EventService;




@Controller
@Scope("session")
public class EventShowAction extends BaseAction {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EventService eventService;
	private List<LsEventHandle> rows;
	private int total;
	
	
	/**
	 *  根据条件来查询
	 * @return
	 */
	public String loadEvents() {
		try{
		rows=new ArrayList<LsEventHandle>();
		//当前页面的数量
		int offset = Integer.parseInt(getRequest().getParameter("pageNumber"));
		//数量
		int limit = Integer.parseInt(getRequest().getParameter("pageSize"));
		/*
		String startDate=getRequest().getParameter("startDate");
		String endDate=getRequest().getParameter("endDate");
		String userNo=getRequest().getParameter("userNo");
		int eventType=Integer.parseInt(getRequest().getParameter("eventType"));
		PageIn<LsEventHandle> pi=new PageIn<LsEventHandle>();
		pi.setPageNumber(offset);
		pi.setPageSize(limit);
		pi.setStartTime(startDate);
		pi.setEndTime(endDate);
		LsEventHandle leh=new LsEventHandle();
		leh.setUserNo(userNo);
		leh.setEventType(eventType);
		pi.setT(leh);
		*/
		PageIn<LsEventHandle> pi=new PageIn<LsEventHandle>();
		pi.setPageNumber(offset);
		pi.setPageSize(limit);
		PageOut<LsEventHandle> events=eventService.loadAll(pi);
		total=events.getTotal();
		rows.clear();
		rows.addAll(events.getList());
        }
		catch (Exception e) {
		}
		return "jsonData";
	   	}
	
	 public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}

	public List<LsEventHandle> getRows() {
		return rows;
	}


	public void setRows(List<LsEventHandle> rows) {
		this.rows = rows;
	}
	
	
	
	

}
