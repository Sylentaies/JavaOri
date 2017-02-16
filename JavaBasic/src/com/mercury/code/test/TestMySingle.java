package com.mercury.code.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mercury.code.MySingle;

public class TestMySingle {

	@Test
	public void test() {
		MySingle ms = MySingle.getInstance();
		MySingle ms2 = MySingle.getInstance();
		assertSame(ms,ms2);
	}

}
