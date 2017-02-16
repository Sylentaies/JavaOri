package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.mercury.code.WrappedString;

public class TestWrappedString {

	@Test
	public void test() {
		Set<Object> set = new HashSet<Object>();
		set.add(new WrappedString("abc"));
		set.add(new WrappedString("abc"));
		set.add(new String("abc"));
		set.add(new String("abc"));
//		assertEquals(3, set.size());
		assertEquals(2,set.size());
	}

}
