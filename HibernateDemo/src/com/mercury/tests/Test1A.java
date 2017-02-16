package com.mercury.tests;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1A {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		// user is in persistence status in session
		User user = (User)session.load(User.class,"Tommy");
		System.out.println(user);
		HibernateUtil.closeSession();
		//when session is closed ,user is detached, but can be modified
		//user.setAge(42);
		user.setName("Scott");
		//open a new session
		Session session2 = HibernateUtil.currentSession();
		session2.merge(user);  //user is persistence in session2
		System.out.println("**********************");
		user = (User)session2.load(User.class,"Tommy");
		System.out.println(user);  // It prints out "Tommy 42"
		//if we make a Transaction at this time, the table will be updated
		Transaction tx = session2.beginTransaction();
		tx.commit();
		HibernateUtil.closeSession();
	}
}
