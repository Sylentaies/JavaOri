package com.mercury.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mercury.beans.LazyBean;
import com.mercury.beans.LocalUser;
import com.mercury.beans.MultiCollection;
import com.mercury.beans.MySingle;
import com.mercury.beans.Person;
import com.mercury.beans.User;
import com.mercury.beans.Wrapper;


public class IoCTest {
	private static ApplicationContext actx;
	@BeforeClass
	public static void setUp() throws Exception {
		actx = new FileSystemXmlApplicationContext("iocconfig.xml");
	}

	@Test
	public void testSetterInjection() {
		User user = (User)actx.getBean("user");
		assertEquals("Mary",user.getName());
		assertEquals(70,user.getAge());
		User user2 = (User)actx.getBean("user");
		assertNotSame(user,user2);
		assertSame(user.getName(),user2.getName());
		assertSame(user.getAge(),user2.getAge()); 
	}
	@Test
	public void testConstructorInjection(){
		Person person = (Person)actx.getBean("person");
		assertEquals("Bruce",person.getFirstname());
		assertEquals("Lee",person.getLastname());
		assertEquals(30,person.getAge());
	}
	public void testForInjectionForComplexBean(){
		Wrapper wp = (Wrapper) actx.getBean("wp");
		User user = wp.getUser();
		assertEquals("Mary",user.getName());
		assertEquals(70,user.getAge());
		Person person = wp.getP();
		assertEquals("Bruce",person.getFirstname());
		assertEquals("Lee",person.getLastname());
		assertEquals(30,person.getAge());
		User user2 = (User)actx.getBean("user");
		assertNotSame(user,user2);
		Wrapper wp2 = (Wrapper)actx.getBean("wp");
		assertSame(wp2.getUser(),user);
		//Prototype wrapped Prototype
		//assertSame(wp2.getUser(),wp.getUser());
		Person person2 = (Person)actx.getBean("person");
		assertSame(person,person2);
	}
	@Test
	public void testForInjectionForComplexBean2(){
		Wrapper wp = (Wrapper)actx.getBean("wp2");
		User user = wp.getUser();
		assertEquals("Mary",user.getName());
		assertEquals(70,user.getAge());
		Person person = wp.getP();
		assertTrue(person==null);
	}
	@Test
	public void testInjectionForSubclass(){
		LocalUser user = (LocalUser)actx.getBean("localUser");
		assertEquals("Princeton",user.getLocation());
		assertEquals("Mary",user.getName());
		assertEquals(70,user.getAge());
	}
	@Test
	public void testInjectionForCollection(){
		MultiCollection mc = (MultiCollection)actx.getBean("mc");
		Set<Integer> set = mc.getSet();
		for(Integer i:set){
			System.out.println(i);
		}
		List<String> list = mc.getList();
		for (String s:list){
			System.out.println(s);
		}
		Map<String,Integer> map = mc.getMap();
		Set<String> mkeys = map.keySet();
		for (String key:mkeys){
			System.out.println(key + "=" +map.get(key));
		}
		Properties props = mc.getProperties();
		Set<Object> pkeys =props.keySet();
		for (Object key:pkeys){
			System.out.println( key.toString() + "=" + props.getProperty((String) key));
		
		}
	}
	@Test
	public void testInjectionForSingleton(){
		MySingle ms = (MySingle)actx.getBean("ms");
		MySingle ms2 = (MySingle)actx.getBean("ms");
		assertSame(ms,ms2);
		// if not use factory-method in configuration if construct a obj in 
		// Java code, it's not a singleton
		//E.A:
		
		/*MySingle ms3 = MySingle.getInstance();
		assertNotSame(ms,ms3);*/
	}
	
	@Test
	public void testInjectionForLazyBean(){
		assertSame(0,LazyBean.getCounter());
		actx.getBean("lazyBean");
		assertEquals(1,LazyBean.getCounter());
	}
	
}
