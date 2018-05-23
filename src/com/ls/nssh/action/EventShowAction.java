package com.ls.nssh.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ls.nssh.common.Page;
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
		//页码
		int offset = Integer.parseInt(getRequest().getParameter("pageNumber"));
		//数量
		int limit = Integer.parseInt(getRequest().getParameter("pageSize"));
	     
		List<LsEventHandle> events=eventService.loadAll(new Page(offset,limit));
		total=events.size();
		rows.clear();
		rows.addAll(events);
		
		
		//List<EventDTO> eventcounts=eventHandleManage.loadEventCounts(eventDTO);
		//total=eventcounts.size();
		//List<EventDTO> events=eventHandleManage.loadEvents(eventDTO,offset,limit);
	     //rows.clear();
	    //rows.addAll(events);
	     
		
	    
	    
	    
		
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
