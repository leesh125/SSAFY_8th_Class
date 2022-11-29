package week2.day_0722.com.startup.ssafy;

public class Company {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void increaseSalary(Employee e) {
		e.salary += 50000000;
		if(e instanceof Engineer) {
			Engineer eg = (Engineer)e;
			eg.skill += ", AI";
		}
		System.out.println(name + "회사 직원 : " + e.getInformation());
	}
}
