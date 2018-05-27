package com.ls.nssh.service;


import java.io.Serializable;
import java.util.List;

import com.ls.nssh.common.PageIn;
import com.ls.nssh.common.PageOut;
import com.ls.nssh.entity.LsEventHandle;


public interface EventService {
	
	public PageOut<LsEventHandle> loadAll(PageIn p);
	public Serializable addEvent(LsEventHandle l);
	public boolean updateEvent(LsEventHandle l);
	public boolean deleteEvent(LsEventHandle l);
	
	
	

}
