package com.tech.mobile.innovative.dbconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tech.mobile.innovative.Users;

public class HibernateUtil {
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	
	public void SaveObject() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//Get the user object to be saved
		Users user = new Users();
		long id = user.getSubscriberId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		
		//Save the transaction
		session.save(user);
		
		//commit transaction
		session.getTransaction().commit();
		session.close();
		sf.close();
		

	
	}
	

}
