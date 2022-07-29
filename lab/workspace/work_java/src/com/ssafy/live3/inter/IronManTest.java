package com.ssafy.live3.inter;

public class IronManTest {

	public static void main(String[] args) {
		IronMan iman = new IronMan();
		Object obj = iman;
		// 인터페이스도 하나의 타입 -> 다형성 가능!
		Heroable hero = iman;
		Transformable tf = iman;
		Fightable figh = iman;

	}

}
