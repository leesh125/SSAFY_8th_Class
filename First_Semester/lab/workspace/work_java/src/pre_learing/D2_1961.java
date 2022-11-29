package pre_learing;

import java.util.Scanner;

public class D2_1961 {

	public static int[][] reverseGraph(int[][] reverse_graph, int[][] graph, int N){
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				reverse_graph[i][j] = graph[N-j-1][i];
			}
		}
		return reverse_graph;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int graph[][] = new int[N][N];
			int[][] reverse_graph_90 = new int[N][N];
			int[][] reverse_graph_180 = new int[N][N];
			int[][] reverse_graph_270 = new int[N][N];
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			reverse_graph_90 = reverseGraph(reverse_graph_90, graph, N);
			reverse_graph_180 = reverseGraph(reverse_graph_180, reverse_graph_90, N);
			reverse_graph_270 = reverseGraph(reverse_graph_270, reverse_graph_180, N);
			
			System.out.printf("#%d\n", test_case);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(reverse_graph_90[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < N; j++) {
					sb.append(reverse_graph_180[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < N; j++) {
					sb.append(reverse_graph_270[i][j]);
				}
				System.out.println(sb);
				sb.setLength(0);
			}
			
		}

	}

}
