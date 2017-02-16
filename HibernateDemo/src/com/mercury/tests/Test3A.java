package com.mercury.tests;

import org.hibernate.*;

import com.mercury.beans.Person;
import com.mercury.util.HibernateUtil;

public class Test3A {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		//How to use load or get method for primary key
		Person person = new Person();
		person.setFirstname("John");
		person.setLastname("Cooper");
		Person person2 = (Person)session.load(Person.class,person);
		System.out.println("person==person2?" + (person==person2));
		System.out.println(person2);
		System.out.println("person==person2?" + (person==person2));
		System.out.println(person);
		HibernateUtil.closeSession();
	}
}
