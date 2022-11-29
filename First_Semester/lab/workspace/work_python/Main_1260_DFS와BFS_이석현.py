import sys
from collections import deque
input = sys.stdin.readline

def dfs(v):
    print(v, end=' ')
    visited[v] = True
    for line in graph[v]:
        if not visited[line]:
            dfs(line)

def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = True

    while q:
        now_v = q.popleft()
        print(now_v, end=' ')
        for line in graph[now_v]:
            if not visited[line]:
                visited[line] = True
                q.append(line)

N, M, V = map(int, input().split())
lines = [list(map(int, input().split())) for _ in range(M)]
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
for line in lines:
    graph[line[0]].append(line[1])
    graph[line[1]].append(line[0])

for i in range(1, N+1):
    graph[i] = sorted(graph[i])

dfs(V)
visited = [False] * (N+1)
print()
bfs(V)