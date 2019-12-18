package com.tech.mobile.innovative.dbconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	
	public void SaveObject() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//Get the user object to be saved
	
		

	
	}
	

}
