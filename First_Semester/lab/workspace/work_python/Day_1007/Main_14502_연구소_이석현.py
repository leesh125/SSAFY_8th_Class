import sys, copy
from collections import deque
from itertools import combinations
input = sys.stdin.readline

n,m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)] # 방
virus = [(i,j) for i in range(n) for j in range(m) if graph[i][j] == 2] # 바이러스 좌표
visited = [[0 for _ in range(m)] for _ in range(n)] # bfs 방문 처리
dx,dy = [-1,1,0,0],[0,0,-1,1] # 상,하,좌,우 이동
coordinate = [(i,j) for i in range(n) for j in range(m) if graph[i][j] == 0] # 
all_combi = list(combinations(coordinate,3))
max_zero = 0

def count_max_zero(copy_graph):
    global max_zero
    cnt = 0
    for i in range(n):
        cnt += copy_graph[i].count(0)
    max_zero = max(max_zero, cnt)

def bfs(x,y,copy_graph, copy_visited):
    q = deque([(x,y)])
    copy_visited[x][y] = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if copy_graph[nx][ny] == 0:
                    copy_graph[nx][ny] = 2
                    copy_visited[nx][ny] = 1
                    q.append((nx,ny))

for combi in all_combi:
    
    copy_graph = copy.deepcopy(graph)
    copy_visited = copy.deepcopy(visited)

    for x,y in combi:
        copy_graph[x][y] = 1
    
    for i,j in virus:
        bfs(i,j,copy_graph,copy_visited)

    count_max_zero(copy_graph)

print(max_zero)