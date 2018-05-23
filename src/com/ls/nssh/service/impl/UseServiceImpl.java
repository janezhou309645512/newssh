package com.ls.nssh.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ls.nssh.dao.UserDao;
import com.ls.nssh.entity.Tuser;
import com.ls.nssh.service.UserService;



@Transactional
@Service
public class UseServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public Serializable add(Tuser u) {
		
		return userDao.add(u);
	}

}
