package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.mercury.code.Closea;

public class CloseaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		HashSet<Closea> hs = new HashSet<Closea>();
		hs.add(new Closea("aa",10));
		hs.add(new Closea("aa",20));
		for (Closea c:hs){
			System.out.println(c.getName()+":"+c.getAge());
		}
	}

}
