package com.nagarro.skyscanner.dao;

import com.nagarro.skyscanner.model.User;

public interface UserDao {

	User getUser(User user);
	
	void saveUser(User user);
}
