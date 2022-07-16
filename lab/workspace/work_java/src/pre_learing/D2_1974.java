package pre_learing;

import java.util.HashMap;
import java.util.Scanner;

public class D2_1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, res;
		boolean flag;
		HashMap<Integer, Integer> map = new HashMap<>();
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] graph = new int[9][9];
			res = 0;
			flag = true;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			map.clear();
			for(int i = 0; i < 9; i++) { // 1. 가로 확인
				for(int j = 0; j < 9; j++) {
					if(map.containsKey(graph[i][j])) flag = false;
					else map.put(graph[i][j], 1);
				}
				map.clear();
			}
			
			if(flag) {
				for(int i = 0; i < 9; i++) { // 2. 세로 확인
					for(int j = 0; j < 9; j++) {
						if(map.containsKey(graph[j][i])) flag = false;
						else map.put(graph[j][i], 1);
					}
					map.clear();
				}
			}
			
			if(flag) {
				Loop1 :
				for(int i = 0; i <= 6; i+=3) {
					for(int j = 0; j <= 6; j+=3) {
						map.clear();
						for(int k = i; k < i+3; k++) {
							for(int z = j; z < j+3; z++) {
								if(map.containsKey(graph[k][z])) {
									flag = false;
									break Loop1;
								}else map.put(graph[k][z], 1);
							}
						}
					}
				}
			}
			res = (flag)? 1 : 0;
			System.out.printf("#%d %d\n",test_case, res);
		}

	}

}
