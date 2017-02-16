package com.mercury.code.test;


import org.junit.Test;

import com.mercury.code.MySingle;
import com.mercury.code.MySingle2;

public class TestMySingle2 {

	@Test
	public void test() {
		for (int i=0; i <10 ; i++){	
			new Thread(){
				@Override
				public void run(){
					MySingle.getInstance();
				}
			}.start();
		}
	}
	
	@Test
	public void test2() {
		for (int i=0; i <10 ; i++){	
			new Thread(){
				@Override
				public void run(){
					MySingle2.getInstance();
				}
			}.start();
		}
	}
}

