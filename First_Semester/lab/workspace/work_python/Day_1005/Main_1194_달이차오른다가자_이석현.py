import sys
from collections import deque
input = sys.stdin.readline
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(i,j):
    q = deque()
    key = 0
    visited = [[[False] * (1<<6) for _ in range(m)] for _ in range(n)]
    visited[i][j][key] = True
    q.append((i,j,key,0))
    
    while q:
        x,y,key,cnt = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            temp_key = key

            if 0<=nx<n and 0<=ny<m and graph[nx][ny] != '#':
                if 'A' <= graph[nx][ny] <= 'F':     
                    if temp_key & (1<<(ord(graph[nx][ny])-ord('A'))) == 0: continue
                elif 'a' <= graph[nx][ny] <= 'f':
                    temp_key |= 1<<(ord(graph[nx][ny])-ord('a'))
                elif graph[nx][ny] == '1': # 탈출구 일 때
                    return cnt+1
                
                if not visited[nx][ny][temp_key]:
                    visited[nx][ny][temp_key] = True
                    q.append((nx,ny,temp_key,cnt+1))
                        
    return -1

n,m = map(int, input().split())
graph = []
minsik = []
for i in range(n):
    graph.append(list(input()))
    for j in range(m):
        if graph[i][j] == '0':
            minsik = [i,j]

print(bfs(minsik[0], minsik[1]))