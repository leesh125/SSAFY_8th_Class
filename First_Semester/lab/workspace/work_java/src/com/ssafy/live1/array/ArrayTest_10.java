package com.ssafy.live1.array;

public class ArrayTest_10 {
	public static void main(String[] args) {
		int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };
		
		// TODO: int로 구성된 배열에서 최대값과 최소값을 출력하시오.
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int n: intArray) {
			if(n > max) max = n;
			if(n < min) min = n;
		}
		
		System.out.println("최대값 : " + max + ", 최소값 : " + min);
		// END:
	}
}
