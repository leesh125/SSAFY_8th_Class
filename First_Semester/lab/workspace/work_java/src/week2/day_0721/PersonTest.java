package week2.day_0721;

public class PersonTest {

	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.name = "김재환";
//		p1.age = 26;
//		
//		Person p2 = new Person();
//		p2.name = "이동욱";
//		p2.age = 16;
		
		System.out.println("총 사람수 : " + Person.getTotalCnt());
		
		Person p1 = new Person("김재환", 27);
		System.out.println(p1.getOrder());
		Person p2 = new Person("이동욱", 16);
		System.out.println(p2.getOrder());
		Person p3 = new Person("김철수");
		System.out.println(p3.getOrder());
		
		p1.printInfo();
		p2.printInfo();
		p3.printInfo();
		

	}

}
