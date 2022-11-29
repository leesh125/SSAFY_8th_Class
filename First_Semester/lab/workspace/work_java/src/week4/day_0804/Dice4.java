package week4.day_0804;

import java.util.Arrays;

public class Dice4 {

	static int N,R;
	static int[] numbers, input = {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		
		N = 6; R = 3;
		numbers = new int[R];
		combination(0,0);
	}

	static void combination(int start, int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start; i<N; i++) {
			numbers[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}
}
