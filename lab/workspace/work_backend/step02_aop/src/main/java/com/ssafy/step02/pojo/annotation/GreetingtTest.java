package com.ssafy.step02.pojo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingtTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		try {
			System.out.println(bean.getClass().getName());
			bean.sayHello("살라");
			System.out.println("===========================");
			bean.sayGoodBye("살라");
		}catch(Exception e) {
			System.out.println("인자 값이 너무 작아요");
			return;
		}
		
	}

}
