package week3.day_0726.com.ssafy.airport;

public class Airplane implements Flyer{

	@Override
	public void takeOff() {
		System.out.println("비행기 이륙");
		
	}

	@Override
	public void fly() {
		System.out.println("비행기 비행");		
	}

	@Override
	public void landing() {
		System.out.println("비행기 착륙");
	}
	

}
