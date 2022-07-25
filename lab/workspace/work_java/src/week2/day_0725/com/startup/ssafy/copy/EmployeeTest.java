package week2.day_0725.com.startup.ssafy.copy;

public class EmployeeTest {

	public static void main(String[] args) {
		Engineer eg = new Engineer("김싸피", 100000000, "Java");
		Manager m = new Manager("김태희", 200000000, "혁신개발1팀");

		
		System.out.println(eg.getInformation());
		System.out.println(m.getInformation());
		
	}

}
