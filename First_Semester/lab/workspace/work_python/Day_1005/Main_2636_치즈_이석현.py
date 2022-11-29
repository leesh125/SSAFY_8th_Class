import sys
from collections import deque
input = sys.stdin.readline
dx = [-1,1,0,0]
dy = [0,0,-1,1]


def bfs(i,j):
    q = deque()
    q.append((i,j))
    visited[i][j] = True
    melt_list = []

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<n and 0<=ny<m and not visited[nx][ny]:
                if graph[nx][ny] == 0:
                    visited[nx][ny] = True
                    q.append((nx,ny))
                elif graph[nx][ny] == 1:
                    visited[nx][ny] = True
                    melt_list.append((nx,ny))
    return melt_list

def melt(melt_list):
    global cheeze
    for x,y in melt_list:
        graph[x][y] = 0
        cheeze -= 1

n,m = map(int, input().split())
graph = []
cheeze,time = 0,0
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(m):
        if graph[i][j] == 1:
            cheeze += 1

while True:
    visited = [[False] * m for _ in range(n)]
    melt_list = bfs(0,0)
    melt(melt_list)
    time += 1
    if cheeze <= 0:
        print(time,len(melt_list),sep='\n')
        break
    


