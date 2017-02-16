package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		//How to call native SQL?
		//First way: define a SQL-query block in the mapping file,
		//				then call getNamedQuery method	
		Query query = session.getNamedQuery("userQuery");
		query.setInteger("age",30);
		List<User> list = query.list();
		for (User u:list){
			System.out.println(u);
		}
		//Second way: call createSQLQuery method directly
		Query query2 = session.createSQLQuery("Select * from sample where Name = :name")
				.addEntity(User.class);
		query2.setString("name", "Tommy");
		User user = (User)query2.uniqueResult();
		System.out.println(user);
		HibernateUtil.closeSession();
		
	}
}
