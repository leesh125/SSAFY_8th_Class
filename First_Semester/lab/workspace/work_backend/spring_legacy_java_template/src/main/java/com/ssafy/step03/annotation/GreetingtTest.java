package com.ssafy.step03.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingtTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		bean.sayHello("살라");
	}

}
