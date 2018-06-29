package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojos.Student;

public class mergeOperation {

	public static void main(String[] args) {
		
		//Building session Factory
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.conf.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//Saving an object before updating it
		saveOperation.save(1,24,"yatish");
		
		
		//Merge Operation
		Session session3 = sessionFactory.openSession(); 
		Student obj2 = session3.get(Student.class, 1);  // here we obj2 object in cache with id=1 
		Student objectWithIDAs1 = new Student();
		objectWithIDAs1.setAge(28);
		objectWithIDAs1.setId(1);
		objectWithIDAs1.setName("Ramya");
		//session3.update(objectWithIDAs1);   // here, if we do update() or save(), then the new object 'objectWithIDAs1', whose id=1 will be sent to session3 cache, but since already have a object obj1 with id=1 in cache, it will give exception
		//solution is below, use merge()
		session3.merge(objectWithIDAs1);  // so, if we use merge() instead of update() or save(), internally instead of giving exception(already object with same ID exists in cache) it will merge the replace the old object obj1 with the new object 'objectWithIDAs1', hence no conflict
		
		
		
		//one more merge() example
		
		// First Session is getting a row from database, which is 'obj'
		Session session1 = sessionFactory.openSession();
		Student obj = session1.get(Student.class, 1);  // here we hae 'obj' with id=1
		session1.close();		// we are closing the session, it will leave out 'obj' object as it has got a reference point in our program with variable 'obj'.
		
		
		//we are opening one more session - session2
		Session session2 = sessionFactory.openSession(); 
		Student obj1 = session2.get(Student.class, 1);  // here we obj1 object in cache with id=1 
		//session2.update(obj); 	// now we are trying to send 'obj' object, which is a different object from obj1, eventhough id's are same, so if send it to cache, it says exception as already we have a object with id=1 in cache, you are sending one more new object with same id, so it causes ambiguity.
		//solution is below, if we use merge, it will merge the latest object to already exiting object in cache, it is almost like replacing the existing object in cache with new object of same key.
		session2.merge(obj);
		
		
		//closing sessions
		session2.close();
		sessionFactory.close();
		
	}

}
