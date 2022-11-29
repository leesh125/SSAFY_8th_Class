package week2.day_0722.com.startup.ssafy;

public class Manager extends Employee {

	String dept;
	
	public Manager(String name, long salary, String dept) {
		super(name, salary);
		this.dept = dept;
	}
	
	void managing() {
		System.out.println(dept + "부서 직원들을 관리합니다.");
	}
}
