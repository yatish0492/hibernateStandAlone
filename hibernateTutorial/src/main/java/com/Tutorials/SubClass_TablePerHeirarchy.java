package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Developer;
import com.pojos.SoftwareEmployees;
import com.pojos.Tester;

public class SubClass_TablePerHeirarchy {

	public static void save(Object obj) {
		Session session = ConnectionSetup.session;
		Transaction trnx = session.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj);
		trnx.commit();
	}
	
	public static void main(String[] args) {
		
		SoftwareEmployees obj = new SoftwareEmployees(1,"Yatish");
		Session session = ConnectionSetup.session;
		Transaction trnx = session.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj);
		trnx.commit();
		Developer obj1 = new Developer(1,"Nitesh","Java");
		Session session1 = ConnectionSetup.session;
		Transaction trnx1 = session1.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj1);
		trnx1.commit();
		Tester obj2 = new Tester(2,"Gagan","Selenium");
		Session session2 = ConnectionSetup.session;
		Transaction trnx2 = session2.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session2.save(obj2);
		trnx2.commit();	

	}

}
