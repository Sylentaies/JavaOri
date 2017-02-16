package com.mercury.code.test;


import org.junit.Test;

public class TestDumpJVM {

	@Test
	public void test() {
		Object[] obj = null;
		while (true){
			obj = new Object[]{obj};
		}
	}

}
