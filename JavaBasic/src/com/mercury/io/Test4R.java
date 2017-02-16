package com.mercury.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test4R {
	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("test4.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Login login = (Login) ois.readObject();
			System.out.println("Username: " + login.getUsername());
			System.out.println("Password: " + login.getPassword());
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End of Main");
	}
}
