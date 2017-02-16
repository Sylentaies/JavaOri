package com.mercury.tests;

import org.hibernate.Session;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5B {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Customer c = (Customer)session.load(Customer.class, 1);
		System.out.println(c.getCid()+"\t" + c.getName());
		HibernateUtil.closeSession();
		for (String email:c.getEmails()){
			System.out.println(email);
		}
	}

}
