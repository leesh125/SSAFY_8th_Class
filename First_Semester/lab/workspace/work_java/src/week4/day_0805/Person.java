package week4.day_0805;

public class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Person o) {
//		return this.name.compareTo(o.getName()); // 오름차순
//		return -this.name.compareTo(o.getName()); // 내림차순
		return o.getName().compareTo(this.name); // 내림차순
	}
}
