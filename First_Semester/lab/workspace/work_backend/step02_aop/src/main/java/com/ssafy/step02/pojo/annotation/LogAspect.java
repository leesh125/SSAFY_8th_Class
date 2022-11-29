package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(void com.ssafy..GreetingService.*Hello(*))")
	private void pointcut() {}
	
	@Before("pointcut()")
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("메소드 호출 전..." + joinPoint.getSignature().getName() + ", " + joinPoint.getArgs());
	}
	
	@After("pointcut()")
	public void afterLogging() {
		System.out.println("메소드 호출 후...");
	}
	
}
