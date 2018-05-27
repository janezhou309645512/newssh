package com.ls.nssh.util;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期的格式化 
 */
public class DateUtil{
	
	/**
	 * 将日期转化为标准格式的字符串
	 * @param date
	 * @return
	 */
	
	public static String getStringDate(Date date){ 
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String str = format.format(date);
	      return str;
	}
	/**
	 * ��������
	 */
	public static String getStringTime(Date date){ 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String str = format.format(date);
	      return str;
	      }
	
	/**
	 * ����ʱ��
	 * @param date
	 * @return
	 */
	public static String getString(Date date){ 
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	   String str = format.format(date);
	      return str;
	}
	
	public static Date getDate(String str){ 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   Date date=null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		      return date;
		}
	/** 
     * �ж��Ƿ�����ĩ 
     * @return 
     */  
    public static boolean isWeekend(String time){
    	boolean b=false;
    	DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");        
    	
    	Date bdate;
		try {
			bdate = format1.parse(time);
			Calendar cal = Calendar.getInstance();
    	    cal.setTime(bdate);
    	    if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
    	 {
    	 b=true;
    	 }
 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return b;    
}
	/** 
	 * ����ʱ����������������Сʱ���ٷֶ����� 
	 * @param str1 ʱ����� 1 ��ʽ��1990-01-01 12:00:00 
	 * @param str2 ʱ����� 2 ��ʽ��2009-01-01 12:00:00 
	 * @return String ����ֵΪ��xx��xxСʱxx��xx�� 
	 */  
  public static String getDistanceTime(String str1, String str2) {  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date one;  
	    Date two;  
	        try {  
	            one = df.parse(str1);  
	            two = df.parse(str2);  
	            long time1 = one.getTime();  
	            long time2 = two.getTime();
	            long diff;
	             
	            if(time1<time2) {  
	              diff = time2 - time1;  
	            } 
	            else{  
	              diff = time1 - time2;  
	            } 
	         BigDecimal d1= new BigDecimal(diff);
	         BigDecimal d2= new BigDecimal(3600000);
	         BigDecimal hour =d1.divide(d2,2,BigDecimal.ROUND_UP);  
	          
	           return  hour.toString();
	            
	           } catch (ParseException e) {  
	            e.printStackTrace();
	            return  "0"; 
	        }  
	         
	    } 
	
	/**
	 * ��ȡ����ʱ���8��
	 * @return
	 */
	public static String getFixedTime(int hour){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY,hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return  getStringDate(c.getTime());
		}
	
	//������
	//�ж��ύʱ��Ϊ�����糿0.00-8:30,��������ǰһ��
	public static String judgeTime(String team){
		 SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
	     SimpleDateFormat sf2= new SimpleDateFormat("HH:mm:ss");
	      String time2=sf1.format(new Date());
	      try {
	    	  if (team.equals("2")) {
	    		  java.util.Date curDate1 = sf1.parse(time2);
	    	      java.util.Date curDate2 = sf2.parse("00:00:00");
	    	      java.util.Date curDate3 = sf2.parse("12:29:59");
	    	      java.util.Date curDate4 = sf2.parse(sf2.format(new Date()));
	    	      if (curDate4.getTime()>curDate2.getTime()&&curDate4.getTime()<curDate3.getTime()){
	    	        Calendar c = Calendar.getInstance();
	    	        c.setTime(curDate1);
	    	        c.add(c.DAY_OF_MONTH, -1);
	    	        curDate1=c.getTime();
	    	        time2 = sf1.format(curDate1);
	    	        }
	    	      else{
	    	    	  }
			}else if (team.equals("no")) {
				
				  java.util.Date curDate1 = sf1.parse(time2);
	    	      java.util.Date curDate2 = sf2.parse("00:00:00");
	    	      java.util.Date curDate3 = sf2.parse("08:29:59");
	    	      java.util.Date curDate4 = sf2.parse(sf2.format(new Date()));
	    	      if (curDate4.getTime()>curDate2.getTime()&&curDate4.getTime()<curDate3.getTime()){
	    	        Calendar c = Calendar.getInstance();
	    	        c.setTime(curDate1);
	    	        c.add(c.DAY_OF_MONTH, -1);
	    	        curDate1=c.getTime();
	    	        time2 = sf1.format(curDate1);
	    	        }
	    	      else{
	    	    	  
	    	    	  }
				
			}else {
				
			}
	     
	      }
	      catch (Exception e) {
			// TODO: handle exception
		}
	      return time2;
	      }
	//�ж�ʱ������ʱ���Ƿ�Ϊ12.30-17.00  17.30-20.30  02.30-8.30
	public static String judgeDistanceTime(String t){
		String s=null;
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
		//ֻҪʱ��
		try {
			Date d=sdf.parse(sdf.format(getDate(t)));
			//12.30-17.00  ��һ��Сʱ
			Date d1 = sdf.parse("12:30:00");
			Date d2 = sdf.parse("17:00:00");
			//18.00-20.30  ��һ���Сʱ
			Date d3 = sdf.parse("17:30:00");
			Date d4 = sdf.parse("20:30:00");
			//00.30-05.00  ��һ����Сʱ
			Date d5 = sdf.parse("02:30:00");
			Date d6 = sdf.parse("08:30:00");
		   //��ȥһ��Сʱ
	  if(d.getTime()>d1.getTime()&&d.getTime()<d2.getTime()){
				Calendar c = Calendar.getInstance();
		        c.setTime(getDate(t));
		        c.add(java.util.Calendar.HOUR_OF_DAY,-1);
		        s=getStringDate(c.getTime());
		        return s;
		  }
		 //��ȥһ����Сʱ
		else if((d.getTime()>d3.getTime()&&d.getTime()<d4.getTime())||(d.getTime()>d5.getTime()&&d.getTime()<d6.getTime())){
			Calendar c = Calendar.getInstance();
	        c.setTime(getDate(t));
	        c.add(java.util.Calendar.HOUR_OF_DAY,-1);
	        c.add(Calendar.MINUTE, -30);//30����ǰ��ʱ��
	        s= getStringDate(c.getTime());	
	        return s;
	        }
		//����ʱ�䲻��
		else{
			s=t;
			return s;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
		
		
		
		
		
		
		
	}
	
	
	  

	
	 
	







}
