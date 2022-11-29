package week4.day_0802.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2805_농작물수확하기_이석현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =  Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] graph= new int[N][N];
			int total = 0;
			
			for(int i=0; i<N; i++) {
				String temp = br.readLine();
				for(int j=0; j<N; j++) {
					graph[i][j] = temp.charAt(j) - '0';
				}
			}
			
			int standard = N / 2;
			int cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=standard-cnt; j<=standard+cnt; j++) {
					total += graph[i][j];
				}
				if(i < standard) {
					cnt++;
				}else {
					cnt--;
				}
			}
			System.out.printf("#%d %d\n",tc,total);
		}
	}

}
