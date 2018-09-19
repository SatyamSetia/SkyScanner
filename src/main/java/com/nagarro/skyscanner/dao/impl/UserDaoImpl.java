package com.nagarro.skyscanner.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.nagarro.skyscanner.constant.HqlQueries;
import com.nagarro.skyscanner.dao.UserDao;
import com.nagarro.skyscanner.model.User;
import com.nagarro.skyscanner.utils.HibernateUtils;


/**
 * @author satyamsetia
 * @description DAO for handling user operations like getUser and createUser.
 * 
 */
public class UserDaoImpl implements UserDao{

	private Session session;

	public UserDaoImpl() {
		this.session = HibernateUtils.createSession();
	}

	public User getUser(User user) {
		this.session.beginTransaction();
		Query query = session.createQuery(HqlQueries.SELECT_USER_FROM_TABLE);
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		List<User> users = query.setMaxResults(1).getResultList();
		this.session.getTransaction().commit();
		return users.size() > 0 ? users.get(0) : null;
	}

	public void saveUser(User user) {
		this.session.beginTransaction();
		Serializable result = this.session.save(user);
		System.out.println(result);
		this.session.getTransaction().commit();
	}

}
