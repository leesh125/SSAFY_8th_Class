import sys
from collections import deque
input = sys.stdin.readline

def bfs(x,y):
    q = deque([(x,y,0,K)])
    dp[0][0] = 0

    while q:
        x,y,cnt,k_cnt = q.popleft()

        if x == h-1 and y == w-1:
            return cnt

        if k_cnt >= 1:
            for i in range(8):
                nx = x + horse_dx[i]
                ny = y + horse_dy[i]

                if 0<=nx<h and 0<=ny<w and graph[nx][ny] != 1:
                    if dp[nx][ny] < k_cnt - 1:
                        q.append((nx,ny,cnt+1,k_cnt-1))
                        dp[nx][ny] = k_cnt - 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<h and 0<=ny<w and graph[nx][ny] != 1:
                if dp[nx][ny] < k_cnt:
                    q.append((nx,ny,cnt+1,k_cnt))
                    dp[nx][ny] = k_cnt
    return -1
                        
K = int(input())
w,h = map(int, input().split())
graph = [list(map(int,input().split())) for _ in range(h)]
dp = [[-1] * w for _ in range(h)]

horse_dx = [-2,-1,1,2,2,1,-1,-2]
horse_dy = [1,2,2,1,-1,-2,-2,-1]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

print(bfs(0,0))