package com.mercury.io;

import java.io.*;

public class Test1 {
	public static void main(String[] args) {
		int[] x = { -1, 2, 3, 4, 257};
		try {
			FileOutputStream fos = new FileOutputStream("test1.dat");
			for (int y : x) {
				fos.write(y);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End of Main");
	}

}
