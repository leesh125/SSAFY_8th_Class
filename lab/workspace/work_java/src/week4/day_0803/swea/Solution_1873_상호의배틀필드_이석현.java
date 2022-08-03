package week4.day_0803.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_1873_상호의배틀필드_이석현 {

	static int height;
	static int width;
	static char[][] graph;
	static char[] userDo;
	static int tankX;
	static int tankY;
	static int tempX;
	static int tempY;
	static int[] dx = {-1,0,1,0}; //  위, 오른, 아래, 왼
	static int[] dy = {0,1,0,-1}; //  위, 오른, 아래, 왼
	static int dir;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] temp = br.readLine().split(" ");
			height = Integer.parseInt(temp[0]);
			width = Integer.parseInt(temp[1]);
			graph = new char[height][width];
			
			for(int i=0; i<height; i++) {
				char[] charArr = br.readLine().toCharArray();
				for(int j=0; j<width; j++) {
					graph[i][j] = charArr[j];
					if(isTank(i,j)) {
						tankX = i;
						tankY = j;
					}
				}
			}
			dir = startDir(tankX, tankY);
			int N = Integer.parseInt(br.readLine());
			userDo = br.readLine().toCharArray();
			
			for(int i=0; i<N; i++) {
				switch(userDo[i]) {
				case 'U':
					userDoOne(0,'^');
					break;
				case 'D':
					userDoOne(2,'v');
					break;
				case 'L':
					userDoOne(3,'<');
					break;
				case 'R':
					userDoOne(1,'>');
					break;
				case 'S':
					tempX = tankX;
					tempY = tankY;
					while(true) {
						tempX += dx[dir];
						tempY += dy[dir];
						if(!isOutOfMap(tempX, tempY)) {
							if(graph[tempX][tempY] == '*') {
								graph[tempX][tempY] = '.';
								break;
							}else if(graph[tempX][tempY] == '#') {
								break;
							}
						}else {
							break;
						}
					}
				}
			}
			bw.write(String.format("#%d ", tc));
			for(int i=0; i<height; i++) {
				String str = new String(graph[i]);
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		}
		bw.close();	
	}
	
	static boolean isTank(int x, int y) {
		if(graph[x][y] == '^' || graph[x][y] == 'v' ||
		   graph[x][y] == '<' || graph[x][y] == '>') {
			return true;
		}
		return false;
	}
	
	static boolean isOutOfMap(int tankX, int tankY) {
		if(tankX < 0 || tankX >= height || tankY < 0 || tankY >= width) {
			return true;
		}
		return false;
	}
	
	static boolean isGround(int x, int y) {
		if(graph[x][y] == '.') {
			return true;
		}
		return false;
	}
	
	static int startDir(int x, int y) {
		switch(graph[x][y]) {
		case '^':
			dir = 0;
			break;
		case '>':
			dir = 1;
			break;
		case 'v':
			dir = 2;
			break;
		case '<':
			dir = 3;
			break;
		}
		return dir;
	}
	
	static void userDoOne(int dir_temp, char c) {
		graph[tankX][tankY] = c;
		dir = dir_temp;
		tempX = tankX + dx[dir];
		tempY = tankY + dy[dir];
		
		if(!isOutOfMap(tempX, tempY) && isGround(tempX, tempY)) {
			graph[tankX][tankY] = '.';
			tankX = tempX;
			tankY = tempY;
			graph[tankX][tankY] = c;
		}
	}

}
