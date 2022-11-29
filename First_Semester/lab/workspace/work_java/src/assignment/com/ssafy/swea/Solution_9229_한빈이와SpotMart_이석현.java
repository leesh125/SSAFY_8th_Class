package assignment.com.ssafy.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_9229_한빈이와SpotMart_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] weight;
	static int total;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] temp = br.readLine().split(" ");
			int N = Integer.parseInt(temp[0]); int M = Integer.parseInt(temp[1]);
			
			temp = br.readLine().split(" ");
			weight = new int[N];
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(temp[i]);
			}
			
			max = -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					total = weight[i] + weight[j];
					if(total <= M) {
						max = (max < total)? total: max; 						
					}
				}
			}
			 
			bw.write(String.format("#%d %d", tc, max));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
