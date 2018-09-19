package com.nagarro.skyscanner.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.skyscanner.constant.Keys;

/**
 * @author satyamsetia
 * @description Utility class for creating session.
 */
public class HibernateUtils {
	
	public static Session createSession() {
		SessionFactory sf=new Configuration().configure(Keys.HIBERNATE_CONFIG_FILE_PATH).buildSessionFactory();
		Session session= sf.openSession();
		return session;
	} 
	
}
