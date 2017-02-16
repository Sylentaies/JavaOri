package com.mercury.tests;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2D {
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		//How to update a record in the table
		//First way: Use HQL or SQL to update it
		String hql = "update User set age= :age where name = :name";
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("age", 10);
		query.setString("name", "Tommy");
		query.executeUpdate();
		tx.commit();
		//Second way: User load or get method and then apply setter
		tx = session.beginTransaction();
		User user=(User)session.load(User.class, "Scott");
		user.setAge(20);
		tx.commit();
		//Third way: Similar to second way, I use Criteria instead
		Criteria ct = session.createCriteria(User.class);
		tx = session.beginTransaction();
		User user2 = (User)ct.add(Restrictions.eq("name","Bob")).uniqueResult();
		user2.setAge(30);
		tx.commit();
		session.close();
	}
}
