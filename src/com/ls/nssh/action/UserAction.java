package com.ls.nssh.action;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ls.nssh.entity.Tuser;
import com.ls.nssh.service.UserService;



@Controller
@Scope("session")
public class UserAction extends BaseAction{
	@Autowired
	private UserService userService;
	private String message;
	public String saveUser(){
		 String name=getRequest().getParameter("name");
	     Tuser t=new Tuser();
	     t.setId(UUID.randomUUID().toString());
		 t.setName(name);
		 t.setPwd("123456");
		 t.setCreatedatetime(new Date());
		 t.setModify(new Date());
		 Serializable a=userService.add(t); 
		 System.out.println(a);
		 message=a.toString();
		 return "jsonData";
		 
		
		
		
		
	}
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
