package com.ls.nssh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HibernateUtil {
	/**
	* 
	* @Title: getSession 
	* @Description: 获取session
	* @param @return    设定文件 
	* @return Session    返回类型 
	* @throws
	 */
	
	public  static Session getSession(){
		Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        SessionFactory sessionFactory = (SessionFactory)factory.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        return session;
	}
	
	

}
