package com.ssafy.step03.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("greeting")
public class GreetingServiceImpl implements GreetingService {

	
	private OutputService outputter;
	
	@Autowired
	public GreetingServiceImpl(OutputService outputter) {
		this.outputter = outputter;
	}

//	public GreetingServiceImpl() {
//		System.out.println("GreetingServiceImpl()");
//	}

	public void setOutputter(OutputService outputter) {
		System.out.println("setOutputter()");
		this.outputter = outputter;
	}

	@Override
	public void sayHello(String name) {
		outputter.output("Hello " + name);
	}

}
