package week2.day_0722.com.startup.ssafy;

// 상속 : 부모를 확장하여 새로운 내용을 덧붙이거나 기존내용을 변경하는 것
public class Engineer extends Employee
{
	
	String skill;
	
	public Engineer(String name, long salary, String skill) {
		super(name, salary);
		this.skill = skill;
	}

	@Override
	public String getInformation() {
		return super.getInformation() + ", skill: " + skill;
	}
	
}
