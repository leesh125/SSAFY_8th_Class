package com.ssafy.live2.extend.person;

public class Person {
	String name = "피터파커";
	
	public Person() {}
	
	public Person(String name){
		this.name = name;
	}
	
	public void eat() {
		System.out.println("냠냠.");
	}
	
	public void jump() {
		System.out.println("두 다리로 폴짝!");
	}
	
	public void jump(String option) {
		
	}
	
	@Override
	public String toString() {
		return "name: " + this.name;
	}
}
