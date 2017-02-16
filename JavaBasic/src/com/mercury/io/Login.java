package com.mercury.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Login implements Externalizable {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Login(){
		System.out.println("Create an instance of Login");
	}
	

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void readExternal(ObjectInput input) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
		username = (String)input.readObject();
		password = "*******";
	}

	@Override
	public void writeExternal(ObjectOutput output) throws IOException {
		// TODO Auto-generated method stub
		output.writeObject(username);
		output.writeObject(password);
	}

	



}
