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
	
	
	
     public String addEvent() throws ParseException{
		
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
		if(a.equals("1")){
			
			message="OK";
		}else{
			message="NO";
		}
		 return "jsonData";
	 }
	
	 public String updateEvent() throws ParseException{
		   
		    int id =Integer.parseInt(getRequest().getParameter("id"));
			String userNo = getRequest().getParameter("userNo");
			int eventType= Integer.parseInt(getRequest().getParameter("eventType"));
			String eventDes = getRequest().getParameter("eventDes");
			LsEventHandle eventDTO=new LsEventHandle();
		    eventDTO.setUserNo(userNo);
			eventDTO.setEventType(eventType);
			eventDTO.setEventDes(eventDes);
			
			if(1==1){
				message="OK";
				
			}else{
				message="NO";
			}
			
		     return "jsonData";
		 }
	
	 public String deleteEvent() throws ParseException{
		
		 int id =Integer.parseInt(getRequest().getParameter("id"));
		 //String userNo = getRequest().getParameter("userNo");
		 //int eventType= Integer.parseInt(getRequest().getParameter("eventType"));
		//String eventDes = getRequest().getParameter("eventDes");
		
		
			//eventDTO.setUserNo(userNo);
			//eventDTO.setEventType(eventType);
			//eventDTO.setEventDes(eventDes);
		
			if(1==1){
				message="OK";
				
			}else{
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
