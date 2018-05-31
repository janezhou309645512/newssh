package com.ls.nssh.action;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
/**
 * 用于返回图表的信息
 * @author jane.zhou1
 *
 */

@Controller
@Scope("session")
public class ChartAction extends BaseAction{
	
	
	private HashMap<String, Object> map;
	
	public String loadCharts(){
		
		try{
			map=new HashMap<String, Object>();
		//String userNo = getRequest().getParameter("userNo");
		
		map.put("x", "['分切', '模切', '手工', 'ipqc', '包装']");
		map.put("y","[5, 3, 4, 7, 2]");
		
		
		
		
		
		
		}catch (Exception e) {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "jsonData";
		
		
		
		
		
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	
	
	
	
	
	
	
	 
	
	

}
