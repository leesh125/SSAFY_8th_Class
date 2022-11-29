package com.ssafy.step04.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingtTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		bean.sayHello("살라");
	}

}
