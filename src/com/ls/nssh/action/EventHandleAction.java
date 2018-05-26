package com.ls.nssh.action;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.service.EventService;

@Controller
@Scope("session")
public class EventHandleAction extends BaseAction{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EventService eventService;
	private String message;
	
	
	
     public String addEvent(){
		try{
		String userNo = getRequest().getParameter("userNo");
		int eventType= Integer.parseInt(getRequest().getParameter("eventType"));
		String eventDes = getRequest().getParameter("eventDes");
		LsEventHandle l=new LsEventHandle();
		l.setId(UUID.randomUUID().toString());
		l.setUserNo(userNo);
		l.setEventType(eventType);
		l.setEventDes(eventDes);
		l.setEventTime(new Date());
		Serializable a=eventService.addEvent(l);
		System.out.println(a.toString());
		if((a.toString()).equals("0")){
			
			message="NO";
		}else{
			message="OK";
		}
		}
		catch (Exception e) {
			message="NO";
		}
		 return "jsonData";
	 }
	
	 public String updateEvent(){
		 try{
		    //传要查询要修改的数据
		    String id =getRequest().getParameter("id");
		    //修改的具体信息
			String userNo = getRequest().getParameter("userNo");
			int eventType= Integer.parseInt(getRequest().getParameter("eventType"));
			String eventDes = getRequest().getParameter("eventDes");
		    LsEventHandle l=new LsEventHandle();
			l.setId(id);
			l.setUserNo(userNo);
			l.setEventType(eventType);
			l.setEventDes(eventDes);
			l.setEventTime(new Date());
			
			boolean res=eventService.updateEvent(l);
			if(res==true){
				message="OK";
				
			}else{
				message="NO";
			}
		 }catch (Exception e) {
			 message="NO";
			
		}
		     return "jsonData";
		 }
	 
	
	 public String deleteEvent(){
		try{
		    String id =getRequest().getParameter("id");
		 
		    LsEventHandle l=new LsEventHandle();
			l.setId(id);
			boolean res=eventService.deleteEvent(l);
		   
			if(res==true){
				message="OK";
				
			}else{
				message="NO";
			}
		}
		catch (Exception e) {
			message="NO";
		}
		     return "jsonData";
		 }
	
	
		
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
			
	
	
	
	
	
	
	

}
