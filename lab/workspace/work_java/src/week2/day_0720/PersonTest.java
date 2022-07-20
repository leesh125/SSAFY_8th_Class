package week2.day_0720;

public class PersonTest {

	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.name = "김재환";
//		p1.age = 26;
//		
//		Person p2 = new Person();
//		p2.name = "이동욱";
//		p2.age = 16;
		
		Person p1 = new Person("김재환", 27);
		Person p2 = new Person("이동욱", 16);
		Person p3 = new Person("김철수");
		
		p1.printInfo();
		p2.printInfo();
		p3.printInfo();
		
		p1.increaseAge();
		p1.increaseAge();
		p2.increaseAge().increaseAge();
		
		p1.printInfo();
		p2.printInfo();
		p3.printInfo();

	}

}
