package com.ls.nssh.dao;

import java.io.Serializable;
import java.util.List;

import com.ls.nssh.common.PageIn;
import com.ls.nssh.common.PageOut;
import com.ls.nssh.entity.LsEventHandle;

public interface EventDao {
	public PageOut<LsEventHandle> loadAll(PageIn<LsEventHandle> p);
	public Serializable addEvent(LsEventHandle l);
	public boolean updateEvent(LsEventHandle l);
	public boolean deleteEvent(LsEventHandle l);

}
