package week5.day_0812;

import java.util.Scanner;

public class CombinationNPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		int[] p = new int[N];
		// 뒤쪽부터 r개만큼 1로 채우기
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		
		do {
			// 완성된 조합 처리
			for(int i=0; i<N; i++) {
				if(p[i] == 1) System.out.print(input[i] + " ");
			}
			System.out.println();
		}while(np(p));
		
	}
	
	public static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		// step1
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		// step2
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		// step3
		swap(numbers, i-1, j);
		
		// step4
		int k = N-1;
		while(i<k) swap(numbers, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
