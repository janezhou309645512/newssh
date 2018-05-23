package com.ls.nssh.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.ls.nssh.dao.UserDao;
import com.ls.nssh.entity.Tuser;
import com.ls.nssh.util.HibernateUtil;


@Repository
public class UserDaoImpl implements UserDao{
	private Session session;
	
	

	public Serializable add(Tuser u) {
		Serializable a=0;
		try{
			session = HibernateUtil.getSession();
			//获取事务
			Transaction tx = session.getTransaction();
			//开启事务
			tx.begin();
			a= session.save(u);
			tx.commit();
		}catch (Exception e) {
			a=0;
		}finally{
			
			session.close();
		}
		return a;
	}
	

}
