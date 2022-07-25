package week2.day_0725.com.startup.ssafy.copy;

public class Employee {
	String name;
	long salary;
	
	
	public Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	void work() {
		System.out.println("열심히 일을 합니다.");
	}
	
	String getInformation() {
		StringBuilder sb = new StringBuilder();
		return sb.append("이름: ").append(name).append(", 연봉: ").append(salary).toString();
	}
	
}
