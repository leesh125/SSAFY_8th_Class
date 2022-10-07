# import sys
# input = sys.stdin.readline
# INF = int(1e9)

# N, M = map(int, input().split())
# graph = [[INF] * (N+1) for _ in range(N+1)]
# fromGraph = [[INF] * (N+1) for _ in range(N+1)]
# ans = 0

# for _ in range(M):
#     fr, to = map(int,input().split())
#     graph[fr][to] = 1
#     fromGraph[to][fr] = 1
    
# for i in range(1,N+1):
#     for j in range(1,N+1):
#         if i == j:
#             graph[i][j] = 0

# for k in range(1,N+1):
#     for i in range(1,N+1):
#         for j in range(1, N+1):
#             graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
#             fromGraph[i][j] = min(fromGraph[i][j], fromGraph[i][k] + fromGraph[k][j])

# for i in range(1,N+1):
#     for j in range(1,N+1):
#         if graph[i][j] == INF and fromGraph[i][j] == INF:
#             break
#         if j == N:
#             ans += 1

# print(ans)

import sys
input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())
graph = [[INF] * (N+1) for _ in range(N+1)]
ans = 0

for _ in range(M):
    fr, to = map(int,input().split())
    graph[fr][to] = 1
    graph[to][fr] = -1
    
for i in range(1,N+1):
    graph[i][i] = 0

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1, N+1):
            if graph[i][k] == graph[k][j] and graph[i][k] != INF:
                graph[i][j] = graph[i][k]
                graph[j][i] = -graph[i][j]

for i in range(1,N+1):
    if max(graph[i][1:]) != INF:
        ans += 1
print(ans)
