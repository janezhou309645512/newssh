package com.ls.nssh.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import com.ls.nssh.common.PageIn;
import com.ls.nssh.common.PageOut;
import com.ls.nssh.dao.EventDao;
import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.util.HibernateUtil;


@Repository
public class EventDaoImpl implements EventDao{
	//只有查询没有事物提交，其他有事物提交
	private Session session;
	 
	public PageOut<LsEventHandle> loadAll(PageIn p) {
		PageOut<LsEventHandle> pd=new PageOut();
		Query q;
		try{
			session = HibernateUtil.getSession();
			 String hql="from LsEventHandle order by eventTime desc";
			 //利用hql查询
			  q = session.createQuery(hql);
			  int total=q.list().size();
			  pd.setTotal(total);
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
	public boolean updateEvent(LsEventHandle l) {
		boolean res=false;
		try{
			session = HibernateUtil.getSession();
			//获取事务
			Transaction tx = session.getTransaction();
			//开启事务
			tx.begin();
			//先通过主键id查询到数据库对象
			LsEventHandle leh= (LsEventHandle)session.get(LsEventHandle.class,l.getId());
			leh.setUserNo(l.getUserNo());
			leh.setEventType(l.getEventType());
			leh.setEventDes(l.getEventDes());
			leh.setEventTime(l.getEventTime());
		    session.update(leh);
			tx.commit();
			res=true;
		}catch (Exception e) {
			res=false;
		}finally{
			
			session.close();
		}
		
		return res;
	}
	 //多条数据删除
	public boolean deleteEvent(LsEventHandle l) {
		boolean res=false;
		try{
			session = HibernateUtil.getSession();
			//获取事务
			Transaction tx = session.getTransaction();
			//开启事务
			tx.begin();
			String[] ids=l.getId().split("&");
			for(int i=0;i<ids.length;i++){
				//先通过主键id查询到数据库对象
				LsEventHandle leh= (LsEventHandle)session.get(LsEventHandle.class,ids[i]);
				session.delete(leh);
				
		    }
			tx.commit();
			res=true;
		}catch (Exception e) {
			res=false;
		}finally{
			
			session.close();
		}
		
		return res;
	}

}
