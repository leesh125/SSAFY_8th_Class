package week3.day_0725.com.startup.ssafy.copy;

public class PolymorphismTest {

	public static void main(String[] args) {
		
//		Engineer eg = new Engineer("김싸피", 10000000, "Java");
//		Employee eg = new Engineer("김싸피", 10000000, "Java");
//		Object eg = new Engineer("김싸피", 10000000, "Java");
//		eg.skill += ",Algorithm"; // Engineer
//		eg.salary += 10000000; // Employee
//		System.out.println(eg.toString()); // Object
		
		
//		Employee eg = new Engineer("김싸피", 10000000, "Java");
		Employee eg = new Manager("김태희", 20000000, "혁신개발1팀");
		
		System.out.println(eg.getInformation());
		
		System.out.println("================================");
		
		Employee[] employees = new Employee[2];
//		Object[] employees = new Employee[2];
		employees[0] = new Engineer("김싸피", 10000000, "Java");  // Employee = Engineer
		employees[1] = new Manager("김태희", 20000000, "혁신개발1팀");
		
		for (Employee employee : employees) {
			System.out.println(employee.getInformation());
		}
		
		
		System.out.println("================================");

		
//		Company cp = Company.getInstance();
//		Company cp2 = Company.getInstance();
//		Company2 cp = Company2.getInstance();
//		Company2 cp2 = Company2.getInstance();
//		Company3 cp = Company3.getInstance();
//		Company3 cp2 = Company3.getInstance();
		Company4 cp = Company4.getInstance();
		Company4 cp2 = Company4.getInstance();
		System.out.println(cp == cp2);
		cp.setName("SSAFY");
		
		Employee eg1 = new Engineer("김싸피", 10000000, "Java");
		Manager m1 = new Manager("김태희", 20000000, "혁신개발1팀");
		
		System.out.println(eg1.getInformation());
		System.out.println(m1.getInformation());
		
		cp.increaseSalary(eg1);
		cp.increaseSalary(m1);
		
	}

}
