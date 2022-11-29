package week4.day_0804;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {

	static int N, R, totalCnt;
	static int[] numbers, input;
	
	// nCr : n개의 입력박은 수 중 n개를 모두 뽑아 순서없이 나열한 것(1<=r<=n)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		comb(0,0);
		System.out.println("총 경우의 수: " + totalCnt);
	}
	
	// cnt+1번째 해당하는 조합에 포함된 수를 뽑기
	private static void comb(int cnt, int start) { // cnt: 직전까지 뽑은 조합에 포함된 수의 갯수, start = 시도할 수의 시작 위치
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		// start 부터 처리시 중복 수 추출 방지 및 순서가 다른 조합 추출 방식
		for(int i = start; i<N; i++) {
			// start 위치부터 처리했으므로 중복체크 필요없음! 
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			// 다음 수 뽑으러 가기
			comb(cnt + 1, i+1);
		}
	}

}
