package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Employee;

public class timeStampOpertion {
	
	
	public static void save(int id, String name) {
		Session session = ConnectionSetup.session;
		Employee obj = new Employee(id,name);
		Transaction trnx = session.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj);
		trnx.commit();	
	}
	
	

	public static void main(String[] args) {
		
		//saving an object 
		save(1,"yatish");  // now the timestamp of inserting this row is table is x
		
		//updating an object
		Session session = ConnectionSetup.session;
		Employee obj = session.get(Employee.class, 1);
		obj.setName("Ashok");
		Transaction trnx = session.beginTransaction(); 
		trnx.commit();	
	}

}
