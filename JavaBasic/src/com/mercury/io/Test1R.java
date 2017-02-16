package com.mercury.io;
import java.io.*;
public class Test1R {
	public static void main(String[] args){
		try {
			FileInputStream fis= new FileInputStream("test1.dat");
			int x= fis.read();
			while (x!=-1){
				System.out.println(x);
				x=fis.read();
			}
			fis.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
