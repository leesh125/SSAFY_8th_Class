package com.ssafy.live1.array;

import java.util.Arrays;

public class ArrayTest_04 {
	public static void main(String[] args) {

		String org = "SSAFY";
		// TODO: char []을 이용해 String org의 각 문자를 저장하고 출력하는 코드를 작성하시오.
		char[] ssafy = new char[org.length()];
		for(int i=0; i<org.length(); i++) {
			ssafy[i] = (char) org.charAt(i);
		}
		System.out.println(Arrays.toString(ssafy));
		
		char[] byapi = org.toCharArray();
		System.out.println(Arrays.toString(byapi));
		// END:
	}
}
