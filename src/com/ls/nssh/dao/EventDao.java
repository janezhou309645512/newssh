package com.ls.nssh.dao;

import java.io.Serializable;
import java.util.List;

import com.ls.nssh.common.Page;
import com.ls.nssh.common.PageData;
import com.ls.nssh.entity.LsEventHandle;

public interface EventDao {
	public PageData<LsEventHandle> loadAll(Page p);
	public Serializable addEvent(LsEventHandle l);
	public Serializable updateEvent(LsEventHandle l);
	public Serializable deleteEvent(LsEventHandle l);

}
