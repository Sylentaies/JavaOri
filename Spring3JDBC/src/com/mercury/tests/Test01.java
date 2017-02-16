package com.mercury.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.User;
import com.mercury.daos.HelloDao;

public class Test01 {
	public static void showUsers(List<User> users) {
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
		HelloDao hd = (HelloDao)actx.getBean("hdb01");
		//save a user
		User user = new User("David",78);
		hd.save(user);
		System.out.println("User is saved");
		//show all users	
		showUsers(hd.query());
		//update the user
		user.setAge(72);
		hd.update(user);
		System.out.println("User is updated");
		showUsers(hd.query());
		//Delete the user
		hd.delete(user);
		System.out.println("User is deleted");
		showUsers(hd.query());
	}

}
