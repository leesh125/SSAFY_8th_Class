package week3.day_0728.com.ssafy.io;

import java.io.Serializable;

public class Person implements Serializable{
	
	private String name;
	private int age;
	private Friend bestFriend;
	
	public Person() {}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, Friend bestFriend) {
		this.name = name;
		this.age = age;
		this.bestFriend = bestFriend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Friend getBestFriend() {
		return bestFriend;
	}

	public void setBestFriend(Friend bestFriend) {
		this.bestFriend = bestFriend;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", bestFriend=" + bestFriend + "]";
	}
	
}
