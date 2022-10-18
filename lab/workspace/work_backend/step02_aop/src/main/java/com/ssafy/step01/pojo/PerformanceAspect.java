package com.ssafy.step01.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
	
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
