package com.ssafy.live1.array;

public class ArrayTest_19 {

    public static void main(String[] args) {


        char[][] grid = {{'2', '3', '1', '4'}, 
                         {'1', 'X', '3', '2'}, 
                         {'3', '4', 'X', 'X'}, 
                         {'X', '4', '1', '5'}};

        int sum = 0;
        int ny = 0;
        int[] dy = {-1,1};
        // TODO: X로 표시된 항목의 좌우 숫자의 합을 구하시오.
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[i].length; j++) {
        		if(grid[i][j] == 'X') {
        			for(int k=0; k<2; k++) {
        				ny = j + dy[k];
        				
        				if(ny >= 0 && ny < grid[i].length) {
        					if(grid[i][ny] != 'X') {
        						sum += (grid[i][ny] - '0');
        					}
        				}
        			}        			
        		}
        	}
        }
        
//        for(int i=0; i<grid.length; i++) {
//        	for(int j=0; j<grid.length; j++) {
//        		if(grid[i][j] == 'X') {
//        			if(j - 1 >= 0 && grid[i][j-1] != 'X') { // 왼쪽
//        				sum += grid[i][j-1] - '0';
//        			}
//        			if(j + 1 < grid[i].length && grid[i][j+1] != 'X') { // 오른쪽
//        				sum += grid[i][j+1] - '0';
//        			}
//        		}
//        		
//        	}
//        }
        // END:
        System.out.println(sum);
    }
}
