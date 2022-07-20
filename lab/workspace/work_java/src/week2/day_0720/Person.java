package week2.day_0720;

public class Person {
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
		System.out.println("init...");
	}

	Person increaseAge() {
		this.age++;
		return this;
	}
	
	void printInfo() {
		System.out.println(name + "," + age);
	}
}
