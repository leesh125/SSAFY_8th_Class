package com.ssafy.step02.setter;

public class OutputServiceImplConsole implements OutputService {
	
	
	
	public OutputServiceImplConsole() {
		System.out.println("OutputServiceImplConsole()");
	}
	
	@Override
	public void output(String msg) {
		System.out.println(msg);
	}

}
