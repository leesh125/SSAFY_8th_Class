package week2.day_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchDirectionTest {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static int x,y;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		String[] temp = br.readLine().split(" ");
		x = Integer.parseInt(temp[0]); 	y = Integer.parseInt(temp[1]);
		
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			map[nx][ny] = 2;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
