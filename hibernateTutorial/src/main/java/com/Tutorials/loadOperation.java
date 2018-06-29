package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Student;

public class loadOperation {

	public static void main(String[] args) {
		
		Session session = ConnectionSetup.session;
		
		
		//Saving an object before getting it
		saveOperation.save(1,24,"yatish");
		
		
		
		/* There is no need to use transaction here, as we are not sending anything back to DB, to execute commit()*/
		
		//Object load(ClassName.class, primary_key)
		 //This will fetch the record from cache if present in cache or else from DB and cache it and then returns to object to code.
		//same as get() but, internally the operation of fetching the data from DB differs. checkout notes for difference between get() and load()
		Student obj2 = (Student)session.load(Student.class,1);
		System.out.println(obj2.getName());

	}

}
