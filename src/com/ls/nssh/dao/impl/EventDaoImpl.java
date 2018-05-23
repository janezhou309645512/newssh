package com.ls.nssh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ls.nssh.common.Page;
import com.ls.nssh.dao.EventDao;
import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.util.HibernateUtil;


@Repository
public class EventDaoImpl implements EventDao{
	//只有查询没有事物提交，其他有事物提交
	private Session session;
	public List<LsEventHandle> loadAll(Page p) {
		try{
			session = HibernateUtil.getSession();
			//利用hql查询
			
			
			
			
			
		}catch (Exception e) {
			
		}finally{
			
			session.close();
		}
		return null;
	}

}
