package com.ls.nssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ls.nssh.dao.EventDao;
import com.ls.nssh.entity.LsEventHandle;
import com.ls.nssh.service.EventService;

@Transactional
@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventDao eventDao;

	public List<LsEventHandle> loadAll() {
	
		return eventDao.loadAll();
	}

}
