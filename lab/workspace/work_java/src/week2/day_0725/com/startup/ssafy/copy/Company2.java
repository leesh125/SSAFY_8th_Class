package week2.day_0725.com.startup.ssafy.copy;

// 디자인 패턴 : 설계 패턴(설계 레시피)
// 				 싱글톤 디자인 패턴 : 객체를 1개만 유지하도록 하는 패턴
//									  클래스 내부에서 객체를 딱 1번만 생성 후 해당 객체의 레퍼런스를 제공
// 									  private, static
// 1. 생성자의 외부 접근을 막기 : private
// 2. 클래스 내부에서 객체를 딱 1번만 생성 후 참조값 저장
// 3. 참조값을 제공해주는 getter 작성

// 장점 : lazy loading
// 단점 : multi thread unsafe
public class Company2 {
	private String name;
	
	private static Company2 instance; // Company.instance = null;
	
	private Company2() {}

	public static Company2 getInstance() {
		if(instance == null) {
			instance = new Company2();
		}
		return instance;
	}
	
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
