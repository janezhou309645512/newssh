package com.ls.nssh.dao;

import java.util.List;

import com.ls.nssh.entity.LsEventHandle;

public interface EventDao {
	public List<LsEventHandle> loadAll();

}
