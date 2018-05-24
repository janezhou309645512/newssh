package com.ls.nssh.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ls.nssh.common.Page;
import com.ls.nssh.common.PageData;
import com.ls.nssh.dao.EventDao;
import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.util.HibernateUtil;


@Repository
public class EventDaoImpl implements EventDao{
	//只有查询没有事物提交，其他有事物提交
	private Session session;
	 Query q;
	public PageData<LsEventHandle> loadAll(Page p) {
		PageData<LsEventHandle> pd=new PageData();
		try{
			session = HibernateUtil.getSession();
			 String hql="from LsEventHandle";
			 //利用hql查询
			  q = session.createQuery(hql);
			  int total=q.list().size();
			  pd.setTotal(total);
			  System.out.println(total+"");
			  
			  //第一页
			  q.setFirstResult(p.getPageNumber());
			  //一页的最大数量
			  q.setMaxResults(p.getPageSize());
			  pd.setList(q.list()); 
			 
		}catch (Exception e) {
			
		}finally{
			
			session.close();
		}
		return pd;
	}
	public Serializable addEvent(LsEventHandle l) {
		Serializable a=0;
		try{
			session = HibernateUtil.getSession();
			//获取事务
			Transaction tx = session.getTransaction();
			//开启事务
			tx.begin();
			a= session.save(l);
			tx.commit();
		}catch (Exception e) {
			a=0;
		}finally{
			
			session.close();
		}
		return a;
		
		
		
	}
	public Serializable updateEvent(LsEventHandle l) {
		// TODO Auto-generated method stub
		return null;
	}
	public Serializable deleteEvent(LsEventHandle l) {
		// TODO Auto-generated method stub
		return null;
	}

}
