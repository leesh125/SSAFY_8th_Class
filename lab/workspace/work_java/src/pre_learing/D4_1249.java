package pre_learing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos { // 큐에 담을 x,y 좌표 객체 
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class D4_1249 {
	
	static int[] dx = {-1,1,0,0}; // x 방향 이동
	static int[] dy = {0,0,-1,1}; // y 방향 이동
	static int[][] map; // 그래프
	static boolean[][] visited; // 방문처리
	static int n; // 테케 번호
	static int min; // 최솟값
	static int[][] ans; // 각 위치당 최소 복구시간 담을 그래프
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine()); 
		
		for(int test=1; test<=testNum; test++) {
			n = Integer.parseInt(br.readLine()); // n X n 배열
			map = new int[n][n]; // n만큼의 맵 생성
			
			for(int i=0; i<n; i++) {
				String[] temp = br.readLine().split("");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(temp[j]); // 맵 채우기
				}
			}
			
			min = Integer.MAX_VALUE; // 초기 최솟값 MAX
			visited = new boolean[n][n]; // 방문 처리 그래프(무한 루프 방지)
			ans = new int[n][n]; // 이동 시간 담을 그래프 생성
			
			for(int i=0; i<n; i++) 
				Arrays.fill(ans[i], Integer.MAX_VALUE); // 초기 이동시간 모두 MAX로 설정
			ans[0][0] = 0; // 출발점 0시간
			
			bfs(0,0); // (0,0) 부터 BFS 탐색
			System.out.printf("#%d %d\n", test, min);	
			
		}
		br.close(); // BufferedReader close 하기

	}
	
	public static void bfs(int x, int y) { // BFS
		Queue<Pos> q = new LinkedList<>(); // 큐 생성
		q.offer(new Pos(x,y)); // 초기(0,0) 큐에 삽입
		visited[x][y] = true; // 방문처리 하기
		
		while(!q.isEmpty()) { // 큐가 차있을동안
			Pos p = q.poll(); // 큐에있는 좌표 빼내기
			int a = p.x; 
			int b = p.y;
			
			if(a == n-1 && b == n-1) { // 도착점 도달 시
				min = min > ans[a][b] ? ans[a][b] : min; // 최솟값보다 작은 수라면 갱신
			}
			
			if(min < ans[a][b]) continue; // 최솟값보다 크면 더이상 탐색 할 필요 없음
			
			for(int i=0; i<4; i++) { // 상,하,좌,우
				int nx = a + dx[i]; // 이동한 x좌표
				int ny = b + dy[i]; // 이동한 y좌표
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 범위 벗어나면 continue
				// 방문하지 않았거나, 이동시간이 갱신될경우
				// 1. 방문 안했을 때 방문하면 최솟값 갱신됨(초기 이동시간 MAX 이기 때문)
				// 2. 방문 했더라도 최솟값 갱신되면 진행시키기
				if(!visited[nx][ny] || (ans[a][b] + map[nx][ny]) < ans[nx][ny]) { 
					ans[nx][ny] = ans[a][b] + map[nx][ny]; // 최솟값 갱신
					visited[nx][ny] = true; // 방문 처리
					q.offer(new Pos(nx, ny)); // 큐에 이동한 좌표 넣기
				}
			}
			
		}
	}

}
