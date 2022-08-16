package assignment.com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기_이석현 {

	static int white,blue;
	static int[][] graph;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		bw.write(String.valueOf(white));
		bw.newLine();
		bw.write(String.valueOf(blue));
		bw.flush();
		bw.close();
	}

	private static void divide(int x, int y, int N) {
		int now = graph[x][y];
		
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(now != graph[i][j]) {
					divide(x,y,(int)N/2);
					divide(x+(int)N/2,y,(int)N/2);
					divide(x,y+(int)N/2,(int)N/2);
					divide(x+(int)N/2,y+(int)N/2,(int)N/2);
					return;
				}
			}
		}
		
		if(now == 1) {
			blue += 1;
		}else {
			white += 1;
		}
	}
}
