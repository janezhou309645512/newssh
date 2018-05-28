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
	 
	public PageOut<LsEventHandle> loadAll(PageIn<LsEventHandle> p) {
		PageOut<LsEventHandle> pd=new PageOut<LsEventHandle>();
		Query q1,q2;
		try{
			session = HibernateUtil.getSession();
			//利用hql查询总记录数
			 String hql1="select count(*) from LsEventHandle";
			 q1 = session.createQuery(hql1);
			  Long countRecord =(Long)q1.uniqueResult(); 
			  int total = countRecord.intValue();  
			  pd.setTotal(total);
			  
			  
			  
			   //String hql2="from LsEventHandle order by eventTime desc";
				String hql2="from LsEventHandle where CONVERT(VARCHAR(100),eventTime,23) between ? and ? and 1=1";
				 
				 if (!((LsEventHandle)p.getT()).getUserNo().isEmpty())
		         {
					 hql2 = hql2 + " and userNo = '" +((LsEventHandle)p.getT()).getUserNo()+ "' ";
		         }
		         if (((LsEventHandle)p.getT()).getEventType()!=0)
		         {
		        	 hql2 = hql2 + " and eventType ="+((LsEventHandle)p.getT()).getEventType();
		         }
		          hql2 = hql2 +" order by eventTime desc";
			  //查询分页数据
			  q2 = session.createQuery(hql2);
			  q2.setFirstResult(p.getPageNumber());
			  //一页的最大数量
			  q2.setMaxResults(p.getPageSize());
			  q2.setParameter(0,p.getStartTime());
			  q2.setParameter(1, p.getEndTime());
			  
			  pd.setList(q2.list()); 
			 
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
