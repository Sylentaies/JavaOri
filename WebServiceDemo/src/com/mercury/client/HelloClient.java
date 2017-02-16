package com.mercury.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mercury.ws.HelloService;

public class HelloClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:1234/ws/hello?wsdl");
		QName qName = new QName("http://ws.mercury.com/", "HelloServiceBeanService");
		Service service = Service.create(url, qName);
		HelloService hs = (HelloService)service.getPort(HelloService.class);
		System.out.println(hs.sayHello("Jason"));
	}
}
