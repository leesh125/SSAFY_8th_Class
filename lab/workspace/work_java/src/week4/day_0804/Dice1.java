package week4.day_0804;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Dice1 {

	static int N,R,totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		N = 6; R = 3;
//		numbers = new int[R];
//		isSelected = new boolean[7];
//		permutation(0);
		N = sc.nextInt();
		numbers = new int[N];
		int mode = sc.nextInt();
		switch(mode) {
		case 1: // 중복순열
			dice1(0);
			break;
		case 2: // 순열
			isSelected = new boolean[7]; // 1~6 주사위눈 선택여부
			dice2(0);
			break;
		case 3: // 중복조합
			dice3(0, 1);
			break;
		case 4: // 조합
			dice4(0, 1);
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
		System.out.println("총 경우의 수 : " + totalCnt);
		
		totalCnt = 0;
		numbers = new int[N];
		
	}

	// 주사위던지기1 : 중복순열
	static void dice1(int cnt) {
//		if(cnt == R) {
//			System.out.println(Arrays.toString(numbers));
//			return;
//		}
//		for(int i=0; i<N; i++) {
//			numbers[cnt] = input[i];
//			permutation(cnt+1);
//		}
		
		// =========================================== //
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		// 가능한 모든 수 시도(주사위 눈 1~6)
		for(int i=1; i<=6;i++) {
			// 수의 중복선택이 가능하므로 중복체크 필요없음
			// 해당 수 선택
			numbers[cnt] = i;
			// 다음 주사위 던지러 가기
			dice1(cnt+1);
		}
	}
	
	static void dice2(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1; i<=6; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}
	
	
	// 주사위 던지기3: 중복조합
	static void dice3(int cnt,int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<=6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	// 주사위 던지기4: 조합
	static void dice4(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<=6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
}
