package com.mercury.tests;

import org.hibernate.Session;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5C {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Customer c = (Customer) session.get(Customer.class, 1);
		
		HibernateUtil.closeSession();
		System.out.println(c.getCid() + "\t" + c.getName());
		for (String email : c.getEmails()) {
			System.out.println(email);
		}
	}
}
