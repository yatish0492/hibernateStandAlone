package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Student;

public class getOperaion {

	public static void main(String[] args) {
		
			
			Session session = ConnectionSetup.session;
			
			
			//Saving an object before getting it
			saveOperation.save(1,24,"yatish");
			
			
			/* There is no need to use transaction here, as we are not sending anything back to DB, to execute commit()*/
			
			//Object get(ClassName.class, primary_key)
		    //This will fetch the record from cache if present in cache or else from DB and cache it and then returns to object to code.
			//NOTE: here the return object(obj1) is not a new object, a reference of object in cache is returned so whatever change we do to this object is reflected in cache object also.
			Student obj1 = (Student)session.get(Student.class,1);
			System.out.println(obj1.getId());
			

	}

}
