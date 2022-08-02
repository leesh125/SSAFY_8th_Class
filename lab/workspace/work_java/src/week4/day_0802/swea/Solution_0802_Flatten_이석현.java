package week4.day_0802.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_0802_Flatten_이석현 {

	static int max_box;
	static int min_box;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split(" ");
			int[] height = new int[101];
			for(String s: temp) {
				height[Integer.parseInt(s)] += 1;
			}
//			height = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();

			while(dump > 0) {
				max_box = get_max(height);
				min_box = get_min(height);
				int gap = max_box - min_box;
				if(gap == 0 || gap == 1) {
					break;
				}
				height[max_box] -= 1;
				height[min_box] -= 1;
				height[max_box-1] += 1;
				height[min_box+1] += 1;
				dump--;
			}

			System.out.printf("#%d %d\n",tc,get_max(height)-get_min(height));
		}
	}

	private static int get_min(int[] height) {
		for(int i=1; i<101; i++) {
			if(height[i] != 0) {
				return i;
			}
		}
		return 1;
	}

	private static int get_max(int[] height) {
		for(int i=100; i>0; i--) {
			if(height[i] != 0) {
				return i;
			}
		}
		return 1;
	}

}
