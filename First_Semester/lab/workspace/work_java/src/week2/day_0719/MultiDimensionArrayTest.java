package week2.day_0719;

public class MultiDimensionArrayTest {

	public static void main(String[] args) {
		
//		scores[0][0] = 100;
//		scores[0][1] = 90;
//		scores[1][0] = 85;
//		scores[1][1] = 99;
//		scores[2][0] = 90;
//		scores[2][1] = 97;

		int[] score = {100, 99, 87};
		
//		int[][] scores = new int[3][];
//		scores[0] = new int[] {100,90};
//		scores[1] = score;
//		scores[2] = new int[] {80,79,100,90};
		
		int[][] scores = {
				{80,79,99,100},
				score,
				{100,90}
		};
		print(scores);
	}
	
	static void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
