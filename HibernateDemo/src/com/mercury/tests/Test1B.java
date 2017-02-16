package com.mercury.tests;
import org.hibernate.*;
import org.hibernate.cfg.*;

import com.mercury.beans.User;

public class Test1B {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		//First Session	
		Session session1 = factory.openSession();
		User user1 = (User)session1.load(User.class, "Tommy");
		System.out.println(user1);
		session1.close();
		try{
			Thread.sleep(6000);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		//second thread
		Session session2 = factory.openSession();
		//The query is running again because of no caching after 6 second
		User user2 = (User)session2.load(User.class, "Tommy");
		System.out.println(user2);
		session2.close();
		//third session
		Session session3 = factory.openSession();
		//The query is not running because of caching on SessionFactory
		User user3 = (User)session3.load(User.class, "Tommy");
		System.out.println(user3);
		System.out.println("user2== user3?"+(user2==user3));
		System.out.println(user2.getName()==user3.getName());
		session3.close();
		
	}

}
