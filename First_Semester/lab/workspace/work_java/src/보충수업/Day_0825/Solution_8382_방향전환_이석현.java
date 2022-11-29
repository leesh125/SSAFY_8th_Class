package 보충수업.Day_0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_8382_방향전환_이석현 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int x1, x2, y1, y2;
	static boolean[][][] visited;
	static Queue<Info> q;
	static class Info {
		int x,y,cnt,check;
		
		private Info(int x, int y, int cnt, int check) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.check = check;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] temp = br.readLine().split(" ");
			x1 = Integer.parseInt(temp[0]); x1 += 100;
			y1 = Integer.parseInt(temp[1]); y1 += 100;
			x2 = Integer.parseInt(temp[2]); x2 += 100;
			y2 = Integer.parseInt(temp[3]); y2 += 100;
			visited = new boolean[201][201][2];
			
			bw.write(String.valueOf("#" + tc + " "));
			bw.write(String.valueOf(bfs(x1,y1)));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static int bfs(int startX, int startY) {
		q = new LinkedList<Info>();
		q.add(new Info(startX, startY, 0, 0));
		q.add(new Info(startX, startY, 0, 1));
		visited[startX][startY][0] = true;
		visited[startX][startY][1] = true;
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			if(info.x == x2 && info.y == y2) return info.cnt;
			
			for(int i=1; i<5; i++) {
				if(i%2 != info.check) continue;
				
				int nx = info.x + dx[i-1];
				int ny = info.y + dy[i-1];
				int next_check = (info.check+1)%2;
				if(0<=nx && nx<=200 && 0<=ny && ny<=200 && !visited[nx][ny][next_check]) {
					visited[nx][ny][next_check] = true;
					q.add(new Info(nx,ny,info.cnt+1, next_check));
				}
			}
		}
		return -1;
	}

}
