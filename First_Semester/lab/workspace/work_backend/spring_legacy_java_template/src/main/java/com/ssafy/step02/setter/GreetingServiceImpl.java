package com.ssafy.step02.setter;


public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter;
	
	
	public GreetingServiceImpl() {
		System.out.println("GreetingServiceImpl()");
	}

	public void setOutputter(OutputService outputter) {
		System.out.println("setOutputter()");
		this.outputter = outputter;
	}

	@Override
	public void sayHello(String name) {
		outputter.output("Hello " + name);
	}

}
