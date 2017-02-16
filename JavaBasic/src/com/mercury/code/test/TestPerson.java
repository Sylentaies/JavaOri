package com.mercury.code.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mercury.code.Person;

public class TestPerson {
	private Person person;
	@Before
	public void setUp() throws Exception {
		person = new Person("Peter");
		System.out.println("Creat an instance of Person");
	}

	@Test
	public void testGetName() {
		assertEquals("Peter",person.getName());
	}
	
	@Test
	public void testAddPrefix(){
		Person person2 = person.addPrefix("Dr.");
		assertEquals("Dr.Peter",person2.getName());
		assertEquals("Peter",person.getName());
		assertNotSame(person, person2);
	}

}
