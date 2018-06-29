package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Student;

public class updateOperation {

	public static void main(String[] args) {
		
		Session session = ConnectionSetup.session;
		
		//Saving an object before updating it
		saveOperation.save(1,24,"yatish");
		
		Transaction trnx = session.beginTransaction();
		
		//update operation
		Student obj1 = session.get(Student.class, 1);
		obj1.setName("Ashoka");  // now the name is already changed to 'Ashoka' in the cache
		//session.update(obj1);  // As per my analysis, there is no need to do update(), as the changes are already present in session cache, this is not necessary. but need to check why is there then!!!!!
		
		trnx.commit();
	}

}
