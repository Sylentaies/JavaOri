package com.mercury.code.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mercury.code.Original;

public class TestOriginal {
	private Original original;
	private Original another;
	@Before
	public void setUp() throws Exception {
		original = new Original("abc");
	}

//	@Test(expected = CloneNotSupportedException.class)
	@Test
	public void testClone() throws CloneNotSupportedException {
		another = original.clone();
		assertNotSame(another, original);
		assertSame(another.getStr(),original.getStr());
		assertEquals(another.getStr(), original.getStr());
		

	}

}
