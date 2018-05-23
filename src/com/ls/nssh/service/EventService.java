package com.ls.nssh.service;

import java.io.Serializable;
import java.util.List;

import com.ls.nssh.common.Page;
import com.ls.nssh.entity.LsEventHandle;


public interface EventService {
	
	public List<LsEventHandle> loadAll(Page p);
	
	
	

}
