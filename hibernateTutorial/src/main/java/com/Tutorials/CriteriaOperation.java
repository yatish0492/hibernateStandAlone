package com.Tutorials;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pojos.Student;

public class CriteriaOperation {

	public CriteriaOperation() {}

	public static void main(String[] args) {
		
		
		//We have HQL, why we need criteria then?
		//A --> consider, if we dont know the query conditions or restrictions while coding. based on the input we need to decide the restrictions at runtime based on inputs. then criterai is better as in HQL we need to write the query with restrictions while coding oly
		//      and criteria supports pagination option, which is not provided by HQL
		
		//**IMPORTANT** We cannot insert/delete/update contents in table, only we can get the data from table using criteria.
		
		//inserting few rows to explain this operation
		saveOperation.save(1, 24, "Yatish");
		saveOperation.save(4, 33, "Ashok");
		saveOperation.save(2, 25, "Harsha");
		saveOperation.save(3, 27, "Ramya");
				
				
		Session session = ConnectionSetup.session;
		
		
		// How to add restrictions to criteria
		Criteria criteria1 = session.createCriteria(Student.class);
		criteria1.add(Restrictions.between("id", 2, 4)).add(Restrictions.isNotNull("Name"));   // As seen here add restriction(conditions) and add it to query. as you can see add() only accepts one Restriction. so we need to use sepeartely add() for each restriction
		//OR
		//criteria1.add(Restrictions.between("id", 2, 4))
		//criteria1..add(Restrictions.isNotNull("Name"));          //Both are same. we can add as many restrictions as we want
		
		List<Student> result1  = criteria1.list();
		Iterator itr1 = result1.iterator();
		while(itr1.hasNext()) {
			Student obj1 = (Student)itr1.next();
			System.out.println(obj1.getName());
		}
		
		//I see that we are getting the output based on criteria restrictions, but is there nay way to do ORDERBY like SQL
		//YES. check below.
		Criteria criteria2 = session.createCriteria(Student.class);
		criteria2.add(Restrictions.between("id", 2, 4)).add(Restrictions.isNotNull("Name"));
		criteria2.addOrder(Order.asc("Name"));    // As seen here, add 'addOrder()' to the criteria and use class 'Order' and use its methods 'asc(PropertyName)' or desc(PropertyName)
		List<Student> result2  = criteria2.list();
		Iterator itr2 = result2.iterator();
		while(itr2.hasNext()) {
			Student obj2 = (Student)itr2.next();
			System.out.println(obj2.getName());
		}
		
		//what is other new feature supported by criteria
		//Don't worry. we need to use projections for that see below
		Criteria criteria3 = session.createCriteria(Student.class);
		criteria3.add(Restrictions.between("id", 2, 4)).add(Restrictions.isNotNull("Name"));
		criteria3.addOrder(Order.asc("Name"));
		criteria3.setFirstResult(1).setMaxResults(2);  // Actually this criteria will give use results in as Ashok,Harsha,Ramya. but since we have set the pagination to 1 to 3. the result list from 'criteria3.list()' will give only object with index 1 to index 2 i.e. Objects with Name as Harsha and Ramya. If we want to print all the pages of size 5, then we have create the criteria for each page and then execute it with indexes incremented and then print
		List<Student> result3  = criteria3.list();  // result3 only contains Harsha,ramya instead of Ashok,Harsha,Ramya because we have set pagination to 1 to 2 in above line
		Iterator itr3 = result3.iterator();
		while(itr3.hasNext()) {
			Student obj3 = (Student)itr3.next();
			System.out.println(obj3.getName());
		}
		
		
		//I see that criteria returns only complete object only. no way to get only selected columns as Object[] !!!!!!!!!
		//Dont worry. we need to use projections for that see below
		Criteria criteria4 = session.createCriteria(Student.class);
		Projection projection = Projections.property("Name");
		criteria4.setProjection(projection);
		List<Object> result4 = criteria4.list();
		Iterator itr4 = result4.iterator();
		while(itr4.hasNext()) {
			String temp = (String)itr4.next();
			System.out.println(temp);
		}
		
		//How can I get more than one column. will the projection with property set always return Object type
		//Dont worry. we need to use projection
		Criteria criteria5 = session.createCriteria(Student.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("id"));
		projectionList.add(Projections.property("Name"));
		criteria5.setProjection(projectionList);
		List<Object[]> result5 = criteria5.list();
		Iterator itr5 = result5.iterator();
		while(itr5.hasNext()) {
			Object[] temp = (Object[])itr5.next();
			System.out.println(temp[0] + "   " + temp[1]);
		}
		
	}

}
