package assignment.com.ssafy.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_1954_달팽이숫자_이석현 {

	static int[][] graph;
	static int[] dx = {0,1,0,-1}; // 오른쪽, 아래, 왼쪽, 위
	static int[] dy = {1,0,-1,0}; 
	static int cnt;
	static int dir;
	static int nx;
	static int ny;
	static int x;
	static int y;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			graph[0][0] = 1;  cnt = 2;  dir = 0; x = 0; y = 0;
			
			while(cnt <= N*N) {
				nx = x + dx[dir];
				ny = y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] != 0) {
					dir = (dir+1) % 4;
				}else {
					graph[nx][ny] = cnt++;
					x = nx; y = ny;
				}
				
			}
			
			bw.write(String.format("#%d", tc));
			bw.newLine();
			for(int[] arr: graph) {
				String str = Arrays.toString(arr).replaceAll("[^0-9 ]","");
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			
		}
		bw.close();
	}

}
