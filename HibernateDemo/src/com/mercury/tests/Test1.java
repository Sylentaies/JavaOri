package com.mercury.tests;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;
public class Test1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
/*		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();*/

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		User user = new User("Bob",50);
		session.save(user);
		tx.commit();
		session.evict(user);
		String hql = "from User";
		Query query = session.createQuery(hql);
		System.out.println("********************");
		List<User> list = query.list();
		for (User u:list){
			System.out.println(u);
			System.out.println("user==u?" + (user==u));
		}
		session.close();
		
		
		
		
	}

}
