package week2.day_0721;

public class Person {
	private String name;
	private int age;
	private static int totalCnt; // class 변수
	private int order; // instance 변수
	
	public Person() {
		System.out.println("Person()");
	}
	
	public Person(String name) {
		this.name = name;
		order = ++totalCnt; // totalCnt:0 ==> 1 order=1, totalCnt:1 ==> 2 order=2
	}
	

	public Person(String name, int age) {
		this(name);
		this.age = age;
		System.out.println("Person(String name, int age)");
	}
	
	static {
		totalCnt = 0;
		System.out.println("static initializer...");
	}
	
	{ // Instance Initializer(객체 초기화자)
		//System.out.println("init...");
		
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

	public static int getTotalCnt() {
		return totalCnt;
	}

	public static void setTotalCnt(int totalCnt) {
		Person.totalCnt = totalCnt;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Person increaseAge() {
		this.age++;
		return this;
	}
	
	void printInfo() {
		System.out.println(order + "/" + totalCnt + ":" + name + "," + age);
	}
}
