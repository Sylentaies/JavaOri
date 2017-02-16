package com.mercury.io;

import java.io.*;

public class Test2R {
	public static void main(String[] args) {
		try{
			FileInputStream fis = new FileInputStream("test2.dat");
			BufferedInputStream buffer = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(buffer);
			System.out.println("Integer : "+dis.readInt());
			System.out.println("Double : "+dis.readDouble());
			System.out.println("Boolean : "+dis.readBoolean());
			dis.close();
			buffer.close();
			fis.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
