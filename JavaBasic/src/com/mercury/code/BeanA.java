package com.mercury.code;

public class BeanA implements Comparable<BeanA> {
	private int x;
	
	public BeanA(){}
	public BeanA(int x){
		this.x = x ;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int compareTo(BeanA another) {
		/*if (x < another.x) return -1;
		else if (x == another.x) return 0;
		else return 1;*/
		
		return x - another.x;
	}

}
