package com.Tutorials;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pojos.Student;

public class HQLQueryOperation {

	public static void main(String[] args) {
		
		//We aleardy have methods from session class like save(), get(), update() etc. then why we have HQL?
		//A --> we can only retrive only one record using above mentioned methods, if we want to fetch multiple records, then HQL is helpful
		
		//inserting few rows to explain this operation
		saveOperation.save(1, 24, "Yatish");
		saveOperation.save(2, 25, "Harsha");
		saveOperation.save(3, 27, "Ramya");
		saveOperation.save(4, 33, "Ashok");
		
		
		Session session = ConnectionSetup.session;
		
		// Getting all the records from a table
		
		Query query1 = session.createQuery("from Student s");
		List<Student> allRecords = query1.list();	
		for(Iterator<Student> itr1 = allRecords.iterator(); itr1.hasNext();) {
			Student temp = itr1.next();
			System.out.println(temp.getId() + " " + temp.getName() + " " + temp.getAge());
		}
		
		//getting only id and age from all records of table
		Query query2 = session.createQuery("select s.Name,s.age from Student s");
		List<Object[]> NameAgesOfStudents = query2.list();
		for(Iterator<Object[]> itr1 = NameAgesOfStudents.iterator(); itr1.hasNext();) {
			Object[] temp = itr1.next();
			System.out.println(temp[0] + " " + temp[1]);
		}
		
		
		//getting only id and age from or record with id=1
		Query query3 = session.createQuery("select s.Name,s.age from Student s where s.id=?");
		query3.setParameter(0, 1);
		List<Object[]> StudentWithId1 = query3.list();
		for(Iterator<Object[]> itr2 = StudentWithId1.iterator(); itr2.hasNext();) {
			Object[] temp = itr2.next();
			System.out.println(temp[0] + " " + temp[1]);
		}
		
		//is there any way that i can give name for parameters instead of ?
		//yes checkout below
		Query query8 = session.createQuery("select s.Name,s.age from Student s where s.Name=:Ramya");  // here instead of ? we have put varaible 'Ramya'. here : is very important to specify that it is parameter
		query8.setParameter("Ramya", new String("yatish"));
		List<Object[]> StudentWithNameYatish = query8.list();
		for(Iterator<Object[]> itr7 = StudentWithNameYatish.iterator(); itr7.hasNext();) {
			Object[] temp = itr7.next();
			System.out.println(temp[0] + " " + temp[1]);
		}
		
		//update name of student with id=1
		Query query5 = session.createQuery("update Student s set s.Name=? where s.id=?");
		query5.setParameter(0, "xyz");
		query5.setParameter(1, 1);
		Transaction trnx1 = session.beginTransaction();
		query5.executeUpdate();
		trnx1.commit();	
		
		
		//insert the contents from table Student to StudentWithIDNameOnly
		Query query7 = session.createQuery("insert into StudentWithIDNameOnly(StudentId,name) select s.id,s.Name from Student s");
		Transaction trnx5 = session.beginTransaction();
		query7.executeUpdate();
		trnx5.commit();
		
		//Delete a row with id=1 in table Student
		Query query4 = session.createQuery("delete from Student s where s.id=?");
		query4.setParameter(0, 1);
		Transaction trnx3 = session.beginTransaction();
		query4.executeUpdate();
		trnx3.commit();
				
		//Delete a row with id=1 in table Student
		Query query6 = session.createQuery("delete from Student s");
		Transaction trnx4 = session.beginTransaction();
		query6.executeUpdate();
		trnx4.commit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
