package com.ssafy.step01.pojo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingtTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		System.out.println(bean.getClass().getName());
		bean.sayHello("살라");
		System.out.println("===========================");
		bean.sayGoodBye("살라");
	}

}
