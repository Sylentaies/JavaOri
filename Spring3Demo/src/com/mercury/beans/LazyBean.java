package com.mercury.beans;

public class LazyBean {
	private static int counter;
	
	public LazyBean(){
		counter++;
	}
	public static int getCounter(){
		return counter;
	}
}
