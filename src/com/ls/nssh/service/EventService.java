package com.ls.nssh.service;


import java.io.Serializable;
import java.util.List;

import com.ls.nssh.common.Page;
import com.ls.nssh.common.PageData;
import com.ls.nssh.entity.LsEventHandle;


public interface EventService {
	
	public PageData<LsEventHandle> loadAll(Page p);
	public Serializable addEvent(LsEventHandle l);
	public boolean updateEvent(LsEventHandle l);
	public boolean deleteEvent(LsEventHandle l);
	
	
	

}
