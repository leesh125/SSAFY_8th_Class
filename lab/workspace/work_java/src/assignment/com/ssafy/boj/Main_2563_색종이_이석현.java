package assignment.com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2563_색종이_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int rectX;
	static int rectY;
	static int[][] graph = new int[101][101];
	static int ans;
	static int n1, n2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split(" ");
			rectX = Integer.parseInt(temp[0]);
			rectY = Integer.parseInt(temp[1]);
			for(int x=rectX; x<rectX+10; x++) {
				for(int y=rectY; y<rectY+10; y++) {
					graph[x][y]++;
				}
			}
		}
		for(int i=0;i<100;i++) {
			for(int j=0; j<100; j++) {
				if(graph[i][j] != 0) ans++;
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
