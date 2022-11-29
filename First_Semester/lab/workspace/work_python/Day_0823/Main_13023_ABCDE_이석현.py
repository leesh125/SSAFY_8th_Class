import sys
from collections import deque
input = sys.stdin.readline

# def bfs(start):
#     global ans
#     q = deque()
#     q.append((start,0))
#     visited = [False] * N
#     visited[start] = True

#     while q:
#         now, cnt = q.popleft()
        
#         if cnt >= 4: ans = 1

#         for friend in graph[now]:
#             if not visited[friend]:
#                 visited[friend] = True
#                 q.append((friend,cnt+1))

def dfs(start,cnt):
    global ans
    visited[start] = True

    if cnt >= 5:
        ans = 1
        return

    for friend in graph[start]:
        if not visited[friend]:
            visited[friend] = True
            dfs(friend,cnt+1)
            visited[friend] = False

N,M = map(int, input().split())
graph = [set() for _ in range(N)]

ans = 0

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

for i in range(N):
    visited = [False] * N
    dfs(i,1)
    if ans == 1: break
print(ans)

# for i in range(N):
#     bfs(i)
#     if ans == 1: break
# print(ans)
