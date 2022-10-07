import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(i,j):
    q = deque()
    q.append((i,j))
    visited[i][j] = True

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and graph[nx][ny] != 0:
                visited[nx][ny] = True
                q.append((nx,ny))
                graph[nx][ny] = tmp

def find_edge(x,y):
    for i in range(4):
        dist = 0
        nx = x
        ny = y
        while True:
            nx += dx[i]
            ny += dy[i]
            if 0<=nx<N and 0<=ny<M:
                if graph[nx][ny] == 0:
                    dist += 1
                elif graph[nx][ny] != graph[x][y]:
                    if dist >= 2:
                        edges.add((graph[x][y],graph[nx][ny],dist))
                        break
                    else:
                        break
                else:
                    break
            else:
                break

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union_parent(fr, to):
    a = find(fr); b = find(to)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
total_cost = 0

visited = [[False] * M for _ in range(N)]
tmp = 1
for i in range(N):
    for j in range(M):
        if graph[i][j] != 0 and not visited[i][j]:
            bfs(i,j)
            graph[i][j] = tmp
            tmp += 1

visited = [[False] * M for _ in range(N)]
edges = set()
for i in range(N):
    for j in range(M):
        if graph[i][j] != 0 and not visited[i][j]:
            find_edge(i,j)

edges = list(edges)
edges.sort(key=lambda x:x[2])

parent = [x for x in range(tmp)]


temp = 0
for fr,to,cost in edges:
    if find(fr) != find(to):
        temp += 1
        union_parent(fr,to)
        total_cost += cost
    if temp == tmp-2:
        break

print(total_cost if temp == tmp-2 else -1)