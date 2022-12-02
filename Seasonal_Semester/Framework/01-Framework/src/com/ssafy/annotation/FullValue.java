package com.ssafy.annotation;

public @interface FullValue {
	String type();
	String name() default "b";
	String value() default "c";
}
