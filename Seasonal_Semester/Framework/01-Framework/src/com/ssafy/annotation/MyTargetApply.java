package com.ssafy.annotation;

@MyTarget
public class MyTargetApply {
	@MyTarget
	private String msg;
	
	@MyTarget
	public void call() {
		
	}
	
	public void test(@MyTarget String msg) {
		@MyTarget
		int val = 100;
	}
}
