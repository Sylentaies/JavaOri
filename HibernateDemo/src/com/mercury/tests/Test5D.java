package com.mercury.tests;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5D {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Criteria ct =  session.createCriteria(Customer.class);
		Customer c = (Customer)ct.add(Restrictions.eq("name","Bob")).uniqueResult();
		HibernateUtil.closeSession();
		for (String email:c.getEmails()){
			System.out.println(email);
		}
	}
}
