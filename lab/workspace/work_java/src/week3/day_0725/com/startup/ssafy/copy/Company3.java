package week3.day_0725.com.startup.ssafy.copy;

// 디자인 패턴 : 설계 패턴(설계 레시피)
// 				 싱글톤 디자인 패턴 : 객체를 1개만 유지하도록 하는 패턴
//									  클래스 내부에서 객체를 딱 1번만 생성 후 해당 객체의 레퍼런스를 제공
// 									  private, static
// 1. 생성자의 외부 접근을 막기 : private
// 2. 참조값을 제공해주는 getter 작성
//		getter 메소드 안에서 객체 생성이 안되어 있을 경우메만 생성 후 리턴
// 3. 객체 생성 판단 여부 부분에서 multi threading시 자원공유 문자게 발생하므로 동기화 처리

// 장점 : lazy loading and multi thread unsafe
public class Company3 {
	private String name;
	
	private static Company3 instance; // Company.instance = null;
	
	private Company3() {}

	public static synchronized Company3 getInstance() {
		if(instance == null) {
			instance = new Company3();
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
