package com.mercury.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mercury.beans.User;

public class Test01 {
	private static final String PERSISTENCE_UNIT_NAME = "user";
	private static EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new User("Smith",72));
		em.getTransaction().commit();
		
		Query query = em.createQuery("select u from User u ");
		List<User> users = query.getResultList();
		for(User u:users){
			System.out.println(u);
		}
		
	}
}
