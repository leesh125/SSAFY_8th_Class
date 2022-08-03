package week4.day_0803.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11660_구간합구하기5_이석현{

	static String[] temp;
	static int[][] nums;
	static int x1,y1,x2,y2;
	static int sum;
	static int[][] dp_row;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		nums = new int[N][N];
		dp_row = new int[N][N];
		
		for(int i=0; i<N; i++) {
			temp = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				nums[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(j == 0) {
					dp_row[i][j] = nums[i][j];
				}else {
					dp_row[i][j] = dp_row[i][j-1] + nums[i][j];
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			sum = 0;
			temp = br.readLine().split(" ");
			x1 = Integer.parseInt(temp[0])-1;  y1 = Integer.parseInt(temp[1])-1; 
			x2 = Integer.parseInt(temp[2])-1;  y2 = Integer.parseInt(temp[3])-1;
			
			for(int j=x1; j<=x2; j++) {
				if(y1 == 0) {
					sum += dp_row[j][y2];
				}else {
					sum += dp_row[j][y2] - dp_row[j][y1-1]; 
				}
			}
			bw.write(String.valueOf(sum));
            bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}