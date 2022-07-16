package pre_learing;

import java.util.Scanner;

public class D2_1959 {
	
	public static int getMax(int[] lt, int[] gt) {
		int max_num = 0;
		
		for(int i = 0; i <= gt.length - lt.length; i++) {
			int tmp = 0;
			for(int j = 0; j < lt.length; j++) {
				tmp += (lt[j] * gt[i+j]);
			}
			if(tmp > max_num) {
				max_num = tmp;
			}
		}
		
		return max_num;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		int res = 0;
		T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] s = sc.nextLine().split(" ");
			int arr1[] = new int[Integer.parseInt(s[0])];
			int arr2[] = new int[Integer.parseInt(s[1])];
			int i = 0;
			
			for(String num: sc.nextLine().split(" ")) {
				arr1[i++] = Integer.parseInt(num);
			}
			i = 0;
			for(String num: sc.nextLine().split(" ")) {
				arr2[i++] = Integer.parseInt(num);
			}
			
			if(arr1.length < arr2.length) {
				res = getMax(arr1, arr2);
			}else {
				res = getMax(arr2, arr1);
			}
			
			System.out.println("#" + test_case + " " + res);
		}

	}

}
