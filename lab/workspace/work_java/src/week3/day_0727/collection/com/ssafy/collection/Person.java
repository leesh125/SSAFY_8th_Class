package week3.day_0727.collection.com.ssafy.collection;

import java.util.Objects;

public class Person {
	static int num;
	String name;
	int age;
	
	public Person() {
		System.out.println("Person()");
	}
	
	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this(name);
		this.age = age;
		System.out.println("Person(String name, int age)");
	}
	
	{ // Instance Initializer(객체 초기화자)
		//System.out.println("init...");
		
	}

	public Person increaseAge() {
		this.age++;
		return this;
	}
	
	void printInfo() {
		num++;
		System.out.println(num + "," + name + "," + age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}
