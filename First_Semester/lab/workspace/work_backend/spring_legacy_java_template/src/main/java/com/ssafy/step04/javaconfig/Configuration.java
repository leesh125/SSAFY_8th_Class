package com.ssafy.step04.javaconfig;

import org.springframework.context.annotation.Bean;

public class Configuration {

	@Bean
	public GreetingService greeting() {
		GreetingServiceImpl g = new GreetingServiceImpl();
		g.setOutputter(outputter());
		return g;
	}
	
	@Bean
	public OutputService outputter() {
		return new OutputServiceImplConsole();
	}
	
}
