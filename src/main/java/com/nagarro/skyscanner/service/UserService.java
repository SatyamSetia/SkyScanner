package com.nagarro.skyscanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.skyscanner.dao.impl.UserDaoImpl;
import com.nagarro.skyscanner.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDaoImpl userDao;
	
	public User validateUser(User user) {
		return this.userDao.getUser(user);
	}
	
	public void registerUser(User user) {
		this.userDao.saveUser(user);
	}
	
}
