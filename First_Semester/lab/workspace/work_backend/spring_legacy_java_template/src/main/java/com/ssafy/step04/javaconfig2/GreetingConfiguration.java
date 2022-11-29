package com.ssafy.step04.javaconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GreetingConfiguration2.class)
public class GreetingConfiguration {

//	@Bean
//	public GreetingService greeting() {
//		GreetingServiceImpl g = new GreetingServiceImpl();
//		return g;
//	}

	@Bean
	public GreetingService greeting(OutputService outputter) {
		GreetingServiceImpl g = new GreetingServiceImpl();
		g.setOutputter(outputter);
		return g;
	}
	
}
