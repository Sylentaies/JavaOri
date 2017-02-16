package com.mercury.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {
	public void start(String name){
		System.out.println(name+" starting.....");
	}
	public void end(String name){
		System.out.println(name+ " ending.....");
	}
	public void error(String name){
		System.out.println(name+" has error.....");
	}
	public void delete(){
		System.out.println("deleting......");
	}
	public Object around(ProceedingJoinPoint pjp,String name)
			throws Throwable{
		System.out.println(name + " around before.....");
		Object obj = pjp.proceed();
		System.out.println(name+" around after.....");
		return obj;
	}
}
