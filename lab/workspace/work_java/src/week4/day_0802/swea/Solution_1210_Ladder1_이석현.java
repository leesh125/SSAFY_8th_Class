package week4.day_0802.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1210_Ladder1_이석현 {

	static int answer;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,0,1};
	static int[] dy = {-1,1,0};
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int testNum = Integer.parseInt(br.readLine());
			graph = new int[100][100];
			visited = new boolean[100][100];
			
			for(int i=0; i<100; i++) {
				String[] temp = br.readLine().split(" ");
				
				for(int j=0; j<100; j++) {
					graph[i][j] = Integer.parseInt(temp[j]);
				}
			}
			flag = false;
			for(int y=0; y<100; y++) {
				visited[0][y] = true;
				isEnd(0,y,visited);
				if(graph[0][y] == 1 && flag) {
					answer = y;
					break;
				}
				visited[0][y] = false;
			}
			System.out.printf("#%d %d\n", testNum, answer);
			
		}

	}

	private static void isEnd(int x, int y, boolean[][] visited) {
		if(x == 99) {
			return;
		}
		
		for(int i=0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || visited[nx][ny]) continue;
			if(graph[nx][ny] == 2) {
				flag = true;
				return;
			}
			if(graph[nx][ny] == 1){
				visited[nx][ny] = true;
				isEnd(nx, ny, visited);
				visited[nx][ny] = false;
				break;
			}
		}
	}

}
