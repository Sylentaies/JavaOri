package com.mercury.tests;

import java.util.List;

import org.hibernate.*;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Customer ct = new Customer("David");
		ct.addEmail("David@gmail.com");	
		session.save(ct);
		tx.commit();
		String hql = "from Customer";
		Query query= session.createQuery(hql);
		List<Customer> list = query.list();
		for(Customer c:list){
			System.out.println(c.getCid() + "\t" + c.getName());
			for(String e : c.getEmails()){
				System.out.println(e);
			}
		}
		HibernateUtil.closeSession();
	}
}
