package com.mercury.tests;

import java.util.Set;

import org.hibernate.*;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5A {
	public static void main(String[] args) {
		
	
		Session session = HibernateUtil.currentSession();
		String hql = "from Customer as c left join fetch c.emails where name = 'Bob'";
		//String hql = "from Customer where name = 'Bob'";
		Customer c = (Customer)session.createQuery(hql).uniqueResult();
		System.out.println(c.getCid() + "\t" + c.getName());
	
		Set<String> emails = c.getEmails();
		Hibernate.initialize(emails);
		HibernateUtil.closeSession();
		
		System.out.println("emails==null"+"\t"+ (emails==null));
		for(String email:emails){
			System.out.println(email);
		}
		
	
	}
	

}
