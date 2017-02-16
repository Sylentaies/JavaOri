package com.mercury.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test4 {
	public static void main(String[] args) {
		try{
			FileOutputStream fos = new FileOutputStream("test4.dat");	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Login login = new Login("abcdefg","1234567");
			oos.writeObject(login);
			oos.close();
			fos.close();		
		}catch (Exception e ){
			e.printStackTrace();
		}
		System.out.println("End of Main");
	}

}
