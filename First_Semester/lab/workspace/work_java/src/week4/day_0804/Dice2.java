package week4.day_0804;

import java.util.Arrays;

public class Dice2 {

	static int N,R;
	static int[] numbers, input = {1,2,3,4,5,6};
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		N = 6; R = 3;
		numbers = new int[R];
		isSelected = new boolean[7];
		permutation(0);
	}

	static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
