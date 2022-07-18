package com.ssafy.live1.oop1.person;

public class PersonTest {

	public static void main(String[] args) {
		// 붕어빵틀 -> 붕어빵
		Person p = new Person(); // Person 즉 클래스 이름은 타입!!
		p.name = "홍길동";
		p.age = 20;
		p.isHungry = true;
		p.eat();
		System.out.println(p.name + " : " + p.isHungry);
		
		Person p2 = new Person();
		p2.name = "장길산";
		System.out.println(p2.name + " : " + p2.isHungry);
	}

}
