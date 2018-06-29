package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Student;

public class saveOperation {
	
	
	public static void save(int id, int age, String name) {
		Session session = ConnectionSetup.session;
		Student obj = new Student(id,name,age);
		Transaction trnx = session.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj);
		trnx.commit();	
	}

	public static void main(String[] args) {
		
		save(1,24,"yatish");
	}

}
