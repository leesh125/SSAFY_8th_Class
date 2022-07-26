package week3.day_0726_oop3.com.ssafy.airport;

public class SuperMan implements Flyer {

	@Override
	public void takeOff() {
		System.out.println("슈퍼맨 이륙");
		
	}

	@Override
	public void fly() {
		System.out.println("슈퍼맨 비행");		
	}

	@Override
	public void landing() {
		System.out.println("슈퍼맨 착륙");
	}
	
	
}
