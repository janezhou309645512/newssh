package com.ls.nssh.service.impl;



import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ls.nssh.common.PageIn;
import com.ls.nssh.common.PageOut;
import com.ls.nssh.dao.EventDao;
import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.service.EventService;

@Transactional
@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventDao eventDao;

	public PageOut<LsEventHandle> loadAll(PageIn<LsEventHandle> p) {
	
		return eventDao.loadAll(p);
	}

	public Serializable addEvent(LsEventHandle l) {
		// TODO Auto-generated method stub
		return eventDao.addEvent(l);
	}

	public boolean updateEvent(LsEventHandle l) {
		// TODO Auto-generated method stub
		return eventDao.updateEvent(l);
	}

	public boolean deleteEvent(LsEventHandle l) {
		// TODO Auto-generated method stub
		return eventDao.deleteEvent(l);
	}

}
