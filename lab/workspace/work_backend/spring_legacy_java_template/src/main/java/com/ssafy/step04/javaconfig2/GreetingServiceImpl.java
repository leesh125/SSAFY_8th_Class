package com.ssafy.step04.javaconfig2;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingServiceImpl implements GreetingService {
	
	private OutputService outputter;
	
	public GreetingServiceImpl() {
		System.out.println("GreetingServiceImpl()");
	}

	public GreetingServiceImpl(OutputService outputter) {
		this.outputter = outputter;
	}

//	@Autowired
	public void setOutputter(OutputService outputter) {
		System.out.println("setOutputter()");
		this.outputter = outputter;
	}

	@Override
	public void sayHello(String name) {
		outputter.output("Hello " + name);
	}

}
