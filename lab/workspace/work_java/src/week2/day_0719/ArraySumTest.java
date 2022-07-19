package week2.day_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySumTest {
	
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static int sum;
	static int res;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = temp[j].charAt(0);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 0;
					sum = 0;
					for(int k=0; k<4; k++) {
						int nx = dx[k] + i;
						int ny = dy[k] + j;
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N | map[nx][ny] == 'X' | !visited[nx][ny]) continue;
						sum += map[nx][ny] - '0';
						visited[nx][ny] = true;
					}
					res += sum;
					map[i][j] = Character.forDigit(sum, 10);
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("res = " + res);

	}

}
