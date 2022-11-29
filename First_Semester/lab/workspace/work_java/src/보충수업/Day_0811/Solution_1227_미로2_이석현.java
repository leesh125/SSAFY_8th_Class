package 보충수업.Day_0811;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1227_미로2_이석현 {

	static int N = 100;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] graph;
	static boolean[][] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("C:\\Users\\leesh\\git\\SSAFY_8th_Class\\lab\\workspace\\work_java\\src\\보충수업\\res\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<11; i++) {
			br.readLine();
			graph = new int[N][N];
			visited = new boolean[N][N];
			for(int j=0; j<N; j++) {
				String s = br.readLine();
				for(int k=0; k<N; k++) {
					graph[j][k] =  s.charAt(k) - '0';					
				}
			}
			bfs(i,1,1);
		}
		
		bw.flush();
		bw.close();
	}
	
	private static void bfs(int tc,int r, int c) throws IOException {
		// 큐 생성하기
		Queue<int[]> queue = new LinkedList<>();
		// 큐에 첫 노드를 추가
		queue.offer(new int[] {r,c});
		
		// 방문 체크 하기
		visited[r][c] = true;
		
		// 모든 노드를 탐색하기 위해 큐에 노드가 없을때까지 반복처리
		while(!queue.isEmpty()) {
			// 큐에서 탐색할 노드를 추출
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];
			// 노드를 통해 처리할 일을 작성 ==> 출력
			
			// 인접한 노드 탐색(4방 탐색)
			for(int i=0; i<4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				// 인접한 노드가 경계내에 있어야하고 방문 안 한 노드인지 검사
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || graph[nr][nc] == 1) continue;
				if(graph[nr][nc] == 3) {
					bw.write("#"+ tc + " 1");
					bw.newLine();
					return;
				}
				// 인접한 노드를 큐에 넣기
				queue.offer(new int[] {nr, nc});
				
				// 방문 체크 하기
				visited[nr][nc] = true;
			}
		}
		bw.write("#" + tc + " 0");
		bw.newLine();
	}

}
