package com.ssafy.step01.pojo;

import org.aspectj.lang.JoinPoint;

public class LogAspect {
	
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("메소드 호출 전..." + joinPoint.getSignature().getName() + ", " + joinPoint.getArgs());
	}
	
	public void afterLogging() {
		System.out.println("메소드 호출 후...");
	}
}
