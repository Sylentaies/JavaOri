package com.mercury.tests;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2B {
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		//Compare load and get method
		User user1 = (User)session.load(User.class, "Tommy");
		//user1 is a proxy object, but is is not null
		System.out.println("user1==null? " + (user1==null));
		System.out.println("*****This is the line display before the query*****");
		System.out.println(user1); //This line will triger the query
		User user2 = (User)session.get(User.class, "Scott");
		System.out.println("*****This is the line display after the query*****");
		System.out.println(user2);
		//If an object does not exist, they have different outputs
		//get method return null
		User user3 = (User)session.get(User.class,"abcd");
		System.out.println(user3);
		//Load method throws a runtime exception
		User user4 = (User)session.load(User.class,"abcd");
		System.out.println(user4);
		HibernateUtil.closeSession();
		
		
	}
}
