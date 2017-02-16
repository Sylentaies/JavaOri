package com.mercury.beans;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String lastname;
	private String firstname;
	private int age;
	
	public Person(){}
	public Person(String first,String last,int age){
		this.firstname = first;
		this.lastname = last; 
		this.age= age;
	}
	
	@Override
	public String toString(){
		return firstname +"\t"+lastname +"(" + age+")";
		
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
