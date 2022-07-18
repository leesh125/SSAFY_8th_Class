package com.ssafy.live1.oop1.person;

public class Person {
	// 멤버 변수 - 속성, 데이터
	String name;
	int age;
	boolean isHungry;
	
	// 멤버 메서드 - 동작
	void eat() {
		System.out.println("냠냠");
		isHungry = false;
	}
	
	void work() {
		System.out.println("열심히...");
		isHungry = true;
	}
}
