package com.Tutorials;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojos.Student;

public class ConnectionSetup {
	
	public static Session session;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.conf.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}
	

	/*public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.conf.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trnx = session.beginTransaction();
		Student obj = new Student();
		obj.setId(1);
		obj.setName("Yatish");
		obj.setAge(24);
		session.save(obj);
		trnx.commit();
		session.close();
		factory.close();
		

	}*/

}
