package com.mercury.code;

public class MySingle {

	private static MySingle instance;

	private MySingle() {
		System.out.println("Create an instance of MySingle");
	}

	public static MySingle getInstance() {
		if (instance == null) {
			// instance = new MySingle();
			synchronized (MySingle.class) {
				if (instance == null) {
					instance = new MySingle();
				}
			}
		}
		return instance;
	}

}
