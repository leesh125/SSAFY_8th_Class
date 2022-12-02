package com.ssafy.annotation;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Class<?> clz = AnnoApply.class;
		
		ClassAnno cA = clz.getAnnotation(ClassAnno.class);
		RunAnno rA = clz.getAnnotation(RunAnno.class);
		
		System.out.println(cA); // 이건 실행시키면 null임
		System.out.println(rA);
		
		Method[] mArr = clz.getDeclaredMethods();
		
		for (Method method : mArr) {
			RunAnno2 rA2 = method.getAnnotation(RunAnno2.class);
			
			if(rA2 == null) continue;
			
			// 이 아래가 실행이 된다는 것은!
			System.out.println(method.getName());
			System.out.println(rA2.id());
			System.out.println(rA2.msg());
		}
	}

}
