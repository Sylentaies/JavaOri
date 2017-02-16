package com.mercury.code;

public class MySingle2 {
	private MySingle2(){
		System.out.println("Create an instance of MySingle2");
	}
	private static class inner{
		static MySingle2 instance = new MySingle2();
		
	}
	public static MySingle2 getInstance(){
		return inner.instance;
	}

}
