package com.mercury.code.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;


import org.junit.Before;
import org.junit.Test;

public class TimeStampText {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String a = (new Timestamp((new java.util.Date()).getTime())).toString();
		Timestamp st = new Timestamp((new java.util.Date()).getTime());
		System.out.println(st.toString());
		System.out.println(st.valueOf(a));
		
		String[] as=new String[1];
		System.out.println(as.length);
		as[1]="abc";
	}

}
