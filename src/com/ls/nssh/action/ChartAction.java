package com.ls.nssh.action;

import java.util.HashMap;
import java.util.Map;

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
	private static final long serialVersionUID = 1L;
	
	
	private Map<Object, Object> paginationData;
	
	public String loadCharts(){
		
		try{
			paginationData=new HashMap<Object, Object>();
		//String userNo = getRequest().getParameter("userNo");
		
			//数组
			String[] x={"分切", "模切", "手工", "ipqc", "包装"};
			int[] y1 = {5, 3, 4, 7, 2};
			int[] y2={1, 3, 4, 4, -2};
			int[] y3={5, -2, 4, -1,3};
			paginationData.put("x", x);
			paginationData.put("y1",y1);
			paginationData.put("y2",y2);
			paginationData.put("y3",y3);
		
		
		
		
		}catch (Exception e) {
			
			
			
		}
		
	  return "paginationData";
		
		
		
		
		
	}

	public Map<Object, Object> getPaginationData() {
		return paginationData;
	}

	public void setPaginationData(Map<Object, Object> paginationData) {
		this.paginationData = paginationData;
	}

	
	
	
	
	
	
	
	 
	
	

}
