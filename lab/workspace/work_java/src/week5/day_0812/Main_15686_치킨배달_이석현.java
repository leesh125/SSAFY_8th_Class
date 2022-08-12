package week5.day_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_이석현 {
	
	private static int[][] graph;
	static List<int[]> chicken;
	static List<int[]> house;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		StringTokenizer st;
		
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				if (graph[i][j] == 2)
					chicken.add(new int[] { i, j });
				else if (graph[i][j] == 1)
					house.add(new int[] { i, j });
			}
		}
		
		for(int[] rest: get_combination(chicken ,M-1)) {
			int chicken_dis = 0;
			for(int[] h : house) {
				int houseX = h[0];
				int houseY = h[1];
				int tmp = Integer.MAX_VALUE;
				for(int r : rest) {
					
				}
			}
		}

	}
	
	private static List<int[][]> get_combination(List<int[]> chicken2, int M) {
		List<int[]> result = new ArrayList<>();
		
		if (M == 0) {
			return null;
		}
		
		for(int i=0; i<chicken2.size(); i++) {
			int[] elem = chicken2.get(i);
			int n = chicken2.size();
			List<int[]> new_chickens = new ArrayList<>();
			System.arraycopy(chicken2.get(0), i+1, new_chickens.get(i), 0, n-1);
			for(int[][] rest: get_combination(new_chickens ,M-1)) {
				result.add(new int[][] {elem,rest});
			}
		}
		return result;
	}
	
}
