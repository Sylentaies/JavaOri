package com.mercury.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TimeBook;
import com.mercury.beans.TimeBookInterface;

public class AOPTest {
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext("aopconfig.xml");
		TimeBookInterface tb = (TimeBookInterface)actx.getBean("logProxy");
		System.out.println(tb.getClass().getName());
		tb.doAudit("Alice");
		tb.doBreak("Bob");
	}

}
