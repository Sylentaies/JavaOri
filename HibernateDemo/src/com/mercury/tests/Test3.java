package com.mercury.tests;

import java.util.List;

import org.hibernate.*;

import com.mercury.beans.Person;
import com.mercury.util.HibernateUtil;

public class Test3 {
	@SuppressWarnings("unchecked")
	public static void main(String[] arg){
		Session session = HibernateUtil.currentSession();
		Person person = new Person("John","Cooper",30);
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		String hql = "from Person";
		List<Person> list = session.createQuery(hql).list();
		for (Person p : list){
			System.out.println(p);
		}
		HibernateUtil.closeSession();
		
	}

}
