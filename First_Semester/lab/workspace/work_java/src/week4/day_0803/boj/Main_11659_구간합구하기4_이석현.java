package week4.day_0803.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11659_구간합구하기4_이석현 {

	static String[] temp;
	static int[] nums;
	static int start;
	static int end;
	static int sum;
	static int dp[] = new int[100000];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		nums = new int[N];
		
		temp = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=0; i<N; i++) {
			if(i == 0) {
				dp[0] = nums[0];
			}else {
				dp[i] = dp[i-1] + nums[i];
			}
		}
		for(int i=0; i<M; i++) {
			sum = 0;
			temp = br.readLine().split(" ");
			start = Integer.parseInt(temp[0])-1;
			end = Integer.parseInt(temp[1])-1;
			if(start == 0) {
				bw.write(String.valueOf(dp[end]));
			}else {
				bw.write(String.valueOf(dp[end] - dp[start-1]));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
