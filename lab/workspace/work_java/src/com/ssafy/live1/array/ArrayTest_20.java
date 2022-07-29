package com.ssafy.live1.array;


public class ArrayTest_20 {
	public static void main(String[] args) {

		char[][] grid = { 
		        { '2', '3', '1', '4' }, 
		        { '1', 'X', '3', '2' }, 
		        { '3', '4', 'X', 'X' },
				{ 'X', '4', '1', '5' } };

		int sum = 0, nx = 0, ny = 0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		// TODO: X로 표시된 항목의 상좌우 숫자의 합을 구하시오.
		//  단 합을 구할 때 이미 더한 영역은 다시 더하지 않는다.
		for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[i].length; j++) {
        		if(grid[i][j] == 'X') {
        			for(int dir=0; dir<4; dir++) {
        				nx = i + dx[dir];
        				ny = j + dy[dir];
        				
        				if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[i].length) continue;
        				if(grid[nx][ny] != 'X') {
        					sum += (grid[nx][ny] - '0');
        					grid[nx][ny] = '0';
        				}
        			}        			
        		}
        	}
      }
		
//		int[][] deltas = {{-1, 0}, {1,0}, {0, -1}, {0,1}};
//		
//		int sum = 0;
//		for(int i=0; i<4; i++) {
//        	for(int j=0; j<4; j++) {
//        		if(grid[i][j] == 'X') {
//        			for(int dir=0; dir<4; dir++) {
//        				int nx = i + deltas[dir][0];
//        				int ny = j + deltas[dir][1];
//        				
//        				if(nx >=0 && nx < 4 && ny >=0 && ny < 4 && grid[nx][ny] != 'X') {
//        					sum += grid[nx][ny] - '0';
//        					grid[nx][ny] = '0';
//        				}
//        			}        			
//        		}
//        	}
//        }
		
		// END:
		System.out.println(sum);
	}
}
