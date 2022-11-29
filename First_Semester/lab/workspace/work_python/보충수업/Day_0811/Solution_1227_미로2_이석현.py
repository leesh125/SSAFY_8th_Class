from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs():
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<100 and 0<=ny<100 and not visited[nx][ny] and graph[nx][ny] != '1':
                if graph[nx][ny] == '3': return 1
                q.append((nx,ny))
                visited[nx][ny] = True
    return 0

for T in range(1,11):
    input()
    graph = [list(input()) for _ in range(100)]
    startX = 1; startY = 1
    visited = [[False] * 100 for _ in range(100)]
    visited[startX][startY] = True
    q = deque()
    q.append((startX, startY))
    print("#{0} {1}".format(T,bfs()))