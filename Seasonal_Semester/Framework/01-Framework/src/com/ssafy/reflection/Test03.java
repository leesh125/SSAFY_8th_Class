package com.ssafy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Test03 {

	public static void main(String[] args) {
		try {
			exam2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 리플랙션을 이용하여 객체를 생성하였다.
	private static void exam() throws Exception {
		// Dog d = new Dog(); // 이것이 목적
		
		Class<Dog> clz = Dog.class;
		Constructor<Dog> constructor = clz.getDeclaredConstructor();
		Dog dog = constructor.newInstance();
		
//		Dog dog = Dog.class.getDeclaredConstructor().newInstance(null);
		
		dog.setName("마루");
		System.out.println(dog.getName());
	}
	
	// 리플랙션을 이용하여 메서드를 실행
	private static void exam2() throws Exception {
		Class<?> clz = Class.forName("com.ssafy.reflection.Dog");
		
		Object obj = clz.getDeclaredConstructor().newInstance(null);
		
		// setName이라는 메서드를 얻어보자
		Method method = clz.getDeclaredMethod("setName", String.class);
		
		// 메서드를 실행하는 방법 : invoke(객체, 매개변수)
		method.invoke(obj, "마리");
		
		method = clz.getDeclaredMethod("getName");
		
		String name = (String)method.invoke(obj);
		System.out.println(name);
	}
}
