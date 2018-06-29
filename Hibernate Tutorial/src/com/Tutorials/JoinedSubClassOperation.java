package com.Tutorials;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.BlackDog;
import com.pojos.Dogs;
import com.pojos.WhiteDog;

public class JoinedSubClassOperation {

	public static void main(String[] args) {
		
		Dogs obj = new Dogs(1,"Snoffy");
		Session session = ConnectionSetup.session;
		Transaction trnx = session.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj);
		trnx.commit();
		WhiteDog obj1 = new WhiteDog(4,"Lucy","Labrador");
		Session session1 = ConnectionSetup.session;
		Transaction trnx1 = session1.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session.save(obj1);
		trnx1.commit();
		BlackDog obj2 = new BlackDog(1,"Toni","Pomorian");
		Session session2 = ConnectionSetup.session;
		Transaction trnx2 = session2.beginTransaction();  //This is very necessary, we cannot directly call session.save(obj)
		session2.save(obj2);
		trnx2.commit();	

	}

}
