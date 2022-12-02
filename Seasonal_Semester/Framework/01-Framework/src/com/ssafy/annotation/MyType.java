package com.ssafy.annotation;

public @interface MyType {

	Class<?> classType();
	String stringType();
	int intType();
	
	Food foddType();
	
	Class<?>[] classArrType();
	
	String[] stringArrDefault() default {"a", "b"};
}
