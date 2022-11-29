package com.ssafy.step04.javaconfig2;

import org.springframework.context.annotation.Bean;

public class GreetingConfiguration2 {

	@Bean
	public OutputService outputter() {
		return new OutputServiceImplConsole();
	}
	
}
