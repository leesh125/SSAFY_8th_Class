package com.ssafy.live6;

import java.util.Scanner;

public class R1_FactorialTest {

	static int factorial1(int n) {
		int res = 1;
		for(int i= n; i>=1; i--) {
			res *= i;
		}
		return res;
	}
	
	static int res = 1;
	static void factorial2(int i) { // i값을 기존 누적값에 곱하는 방식으로 계승을 구한다.
		if(i<1) return;
		res *= i;
		factorial2(i-1);
	}
	
	static int factorial3(int n) { // n! 계산
		
		if(n<=1) return 1;
		
		return n * factorial3(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(factorial1(n));
		factorial2(n);
		System.out.println(res);
	}

}
