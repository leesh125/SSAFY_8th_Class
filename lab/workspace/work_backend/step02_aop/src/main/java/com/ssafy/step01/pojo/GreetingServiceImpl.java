package com.ssafy.step01.pojo;


public class GreetingServiceImpl implements GreetingService {

	@Override
	public void sayHello(String name) {
		for(int i=0; i<=10000000; i++) {
			
		}
		System.out.println("Hello " + name);
	}

	@Override
	public void sayGoodBye(String name) {
		System.out.println("Good Bye " + name);
	}

}
