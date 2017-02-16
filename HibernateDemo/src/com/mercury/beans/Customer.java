package com.mercury.beans;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private int cid;
	private String name;
	private Set<String> emails;
	
	public Customer(){
		emails =new HashSet<String>();
	}
	public Customer(String name){
		this();
		this.name = name;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getEmails() {
		return emails;
	}
	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	
	public void addEmail(String email){
		emails.add(email);
	}
	public void removeEmail(String email){
		emails.remove(email);
	}

}
