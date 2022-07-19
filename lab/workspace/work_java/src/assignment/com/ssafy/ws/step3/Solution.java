package assignment.com.ssafy.ws.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int tmp_x;
	static int tmp_y;
	static int cnt;
	static int max;
	static int N;
	static int tmp;
	static boolean flag;
	static char[][] map;
	
	static int countHeight(char[][] map, int row, int col) {
		int heightSum = 0;
		for(int i = 0; i < N; i++) {
			heightSum += map[i][col];
		}
		heightSum += Collections.frequency(Arrays.asList(map[row]), "B");
		if(map[row][col] == 'B') heightSum--;
		return heightSum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int testNum=1; testNum<=testCase; testNum++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				String[] temp = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = temp[j].charAt(0);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cnt = 0; tmp = 0;  flag = false;
					for(int k=0; k<8; k++) {
						int nx = i + dx[i];
						int ny = i + dy[i];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(map[i][j] == 'G') {
							cnt = 2;
							break;
						}
						if(k == 7) {
							flag = true;
							tmp_x = i;
							tmp_y = j;
						}
					}
					if(flag) {
						tmp = countHeight(map, tmp_x, tmp_y);
						cnt = cnt < tmp ? tmp : cnt;
					}
					max = max < cnt ? cnt: max;
				}
			}
			
			System.out.printf("#%d %d\n",testNum, max);
		}

	}

}
