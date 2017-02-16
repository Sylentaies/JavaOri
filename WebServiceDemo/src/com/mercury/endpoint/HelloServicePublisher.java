package com.mercury.endpoint;

import javax.xml.ws.Endpoint;

import com.mercury.ws.HelloService;
import com.mercury.ws.HelloServiceBean;

// Endpoint Publisher
public class HelloServicePublisher {
	public static void main(String[] args) {
		HelloService hs = new HelloServiceBean();
		Endpoint.publish("http://localhost:1234/ws/hello", hs);
		System.out.println("Complete publishing HelloService");
	}
}
