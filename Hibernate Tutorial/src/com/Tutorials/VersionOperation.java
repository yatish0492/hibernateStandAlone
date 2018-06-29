package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Student;

public class VersionOperation {

	public static void main(String[] args) {
		
		
		Session session = ConnectionSetup.session;
		
		//Saving an object before updating it
		saveOperation.save(1,24,"yatish");  //now the version of this will be 0
		
		
		Student obj = session.get(Student.class, 1);
		Transaction trnx = session.beginTransaction();
		obj.setAge(16);   
		trnx.commit();   // now the version of this will be 1
		
		Transaction trnx1 = session.beginTransaction();
		obj.setAge(34);
		trnx1.commit();  // now the version of this will be 2

	}

}
