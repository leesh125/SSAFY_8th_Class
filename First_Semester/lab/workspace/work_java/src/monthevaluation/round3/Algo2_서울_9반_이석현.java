import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2_서울_9반_이석현 {
	
	static class Pos{
		public int x;
		public int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static char[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Pos home, kinder;
	static ArrayList<Pos> candidate;
	static boolean[][] visited;
	static char[] block = {'|', '-', '+', '1', '2', '3', '4'};
	static int ansX, ansY;
	static char ansChar;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new char[N][M];
			candidate = new ArrayList<>();
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				String temp = br.readLine();
				for(int j=0; j<M; j++) {
					graph[i][j] = temp.charAt(j);
					if(graph[i][j] == 'M') {
						home = new Pos(i,j);
					}else if(graph[i][j] == 'Z') {
						kinder = new Pos(i,j);
					}else if(graph[i][j] != '.') {
						addCandidate(i,j);
					}
				}
			}
			
			for (Pos pos : candidate) {
				backtrack(pos);
				if(ansX != 0) {
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ansX).append(" ").append(ansY).append(" ").append(ansChar);
			System.out.println(sb.toString());
		}
		
	}

	private static void backtrack(Pos pos) {
		int x = pos.x; int y = pos.y;
		for(char c: block) {
			graph[x][y] = c;
			if(bfs(home,c)) {
				ansX = x+1; ansY = y+1;
				ansChar = c;
				return;
			}
			graph[x][y] = '.';
		}
		for(char c: block) {
			graph[x][y] = c;
			if(bfs(kinder,c)) {
				ansX = x+1; ansY = y+1;
				ansChar = c;
				return;
			}
			graph[x][y] = '.';
		}
	}

	private static boolean bfs(Pos pos, char c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(pos);
		boolean[][] t_visited = new boolean[N][M];
		t_visited[pos.x][pos.y] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			int x = temp.x; int y = temp.y;
			System.out.println(temp.x + " " + temp.y);
			if(graph[pos.x][pos.y] == 'M' && graph[x][y] == 'Z') {
				System.out.println("hello");
				return true;
			}
			if(graph[pos.x][pos.y]=='Z' && graph[x][y] == 'M') return true;
			
			if(0 > x || x >= N || 0 > y || y >= M) continue;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= M || t_visited[nx][ny]) continue;
				if(graph[nx][ny] == '|') {
					q.add(new Pos(nx-1, ny));
					t_visited[nx-1][ny] = true;
					q.add(new Pos(nx+1, ny));
					t_visited[nx+1][ny] = true;
				}else if(graph[nx][ny] == '-') {
					q.add(new Pos(nx, ny-1));
					t_visited[nx][ny-1] = true;
					q.add(new Pos(nx, ny+1));
					t_visited[nx][ny+1] = true;
				}else if(graph[nx][ny] == '+') {
					q.add(new Pos(nx-1, ny));
					t_visited[nx-1][ny] = true;
					q.add(new Pos(nx+1, ny));
					t_visited[nx+1][ny] = true;
					q.add(new Pos(nx, ny-1));
					t_visited[nx][ny-1] = true;
					q.add(new Pos(nx, ny+1));
					t_visited[nx][ny+1] = true;
				}else if(graph[nx][ny] == '1') {
					q.add(new Pos(nx-1, ny));
					t_visited[nx-1][ny] = true;
					q.add(new Pos(nx, ny+1));
					t_visited[nx][ny+1] = true;
				}else if(graph[nx][ny] == '2') {
					q.add(new Pos(nx-1, ny));
					t_visited[nx-1][ny] = true;
					q.add(new Pos(nx, ny+1));
					t_visited[nx][ny+1] = true;
				}else if(graph[nx][ny] == '3') {
					q.add(new Pos(nx, ny-1));
					t_visited[nx][ny-1] = true;
					q.add(new Pos(nx-1, ny));
					t_visited[nx-1][ny] = true;
				}else if(graph[nx][ny] == '4') {
					q.add(new Pos(nx+1, ny));
					t_visited[nx+1][ny] = true;
					q.add(new Pos(nx, ny-1));
					t_visited[nx][ny-1] = true;
				}
			}
		}
		return false;
	}

	private static void addCandidate(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 > nx || nx >= N || 0 > ny || ny >= M) continue;
			if(!visited[nx][ny]) {
				if(graph[nx][ny] == '.') {
					visited[nx][ny] = true;
					candidate.add(new Pos(nx,ny));
				}else if(graph[nx][ny] != 'M' && graph[nx][ny] != 'Z' && graph[nx][ny] != '|'&& graph[nx][ny] != '-'&& graph[nx][ny] != '+'&& graph[nx][ny] != '1'&& graph[nx][ny] != '2' && graph[nx][ny] != '3' && graph[nx][ny] != '4'){
					candidate.add(new Pos(nx,ny));
					visited[nx][ny] = true;
				}
			}
		} 
	}

}
