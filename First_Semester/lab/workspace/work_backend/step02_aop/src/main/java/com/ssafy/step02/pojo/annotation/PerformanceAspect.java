package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
public class PerformanceAspect {
	
	@Pointcut("execution(void com.ssafy..GreetingService.*Hello(*))")
	private void pointcut() {}
	
	@Around("pointcut()")
	public Object timeCheck(ProceedingJoinPoint joinPoint){
		
		Signature s = joinPoint.getSignature();
		System.out.println("\t" + s.getName() + "'s time check start...");
		long begin = System.currentTimeMillis(); // before
		Object o = null;
		try {
			o = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("\t" + s.getName()+ "'s processing time is " + (System.currentTimeMillis() - begin) + "ns"); // after
		
		return o;
	}
	
	
}
