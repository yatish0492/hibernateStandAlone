package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Human;
import com.pojos.NonPhysicallyChallenged;
import com.pojos.physicallyChallenged;

public class UnionSubClassOperation {

	public UnionSubClassOperation() {}

	public static void main(String[] args) {
		
		Human obj = new Human(1,"Yatish");
		Session session = ConnectionSetup.session;
		Transaction trnx = session.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj);
		trnx.commit();
		NonPhysicallyChallenged obj1 = new NonPhysicallyChallenged(4,"Nitesh","Java");
		Session session1 = ConnectionSetup.session;
		Transaction trnx1 = session1.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj1);
		trnx1.commit();
		physicallyChallenged obj2 = new physicallyChallenged(4,"Gagan","Selenium");
		Session session2 = ConnectionSetup.session;
		Transaction trnx2 = session2.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session2.save(obj2);
		trnx2.commit();	

	}

}
