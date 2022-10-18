package com.ssafy.step03.annotation;

import org.springframework.stereotype.Component;

@Component("outputter")
public class OutputServiceImplConsole implements OutputService {
	

	public void output(String msg) {
		System.out.println(msg);
	}

}
