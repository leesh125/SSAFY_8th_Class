package com.ssafy.annotation;

public class SingleApply {
	
	@SingleValue1(value="test")
	@SingleValue2(name="test2")
	public void apply1() {}
	
//	@SingleValue1  에러발생 default가 없음
//	@SingleValue2("test3")
//	@SingleValue1("test3") 가능 value만 생략 가능
//	@SingleValue3 가능
//	@SingleValue4 가능
	public void apply2() {}
}
