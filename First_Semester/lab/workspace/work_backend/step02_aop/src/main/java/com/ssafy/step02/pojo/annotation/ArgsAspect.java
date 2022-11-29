package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class ArgsAspect {
	
	@Pointcut("execution(void com.ssafy..GreetingService.*Hello(java.lang.String))")
	private void pointcut() {}
	
	
	@Before("pointcut()")
	public void argsCheck(JoinPoint joinPoint) {
		String args = (String) joinPoint.getArgs()[0];
		if(args.length() < 3) {
			System.out.println("매개변수: " + args);
			System.out.println("함수 종료!!");
			throw new IllegalArgumentException();
		}
	}
}
