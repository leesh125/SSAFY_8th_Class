import sys
input = sys.stdin.readline

def dfs(x,y,dir):
    if dp[dir][x][y] != -1: return dp[dir][x][y]

    if dir == 0:
        if y == 1: return 0
        if graph[x][y] or graph[x][y-1]: return 0

        dp[dir][x][y] = dfs(x,y-1,dir) + dfs(x,y-1,2)
        return dp[dir][x][y]
    elif dir == 1:
        if x == 1: return 0
        if graph[x][y] or graph[x-1][y]: return 0

        dp[dir][x][y] = dfs(x-1,y,dir) + dfs(x-1,y,2)
        return dp[dir][x][y]
    else:
        if x == 1 or y == 1: return 0
        if graph[x][y] or graph[x-1][y] or graph[x][y-1] or graph[x-1][y-1]: return 0

        dp[dir][x][y] = dfs(x-1,y-1,dir) + dfs(x-1,y-1,0) + dfs(x-1,y-1,1)
        return dp[dir][x][y]

N = int(input())
graph = [[0] * (N+1)]

for _ in range(N):
    graph.append([0] + list(map(int,input().split())))

dp = [[[-1] * (N+1) for _ in range(N+1)] for _ in range(3)]
dp[0][1][2] = 1
total = 0
for i in range(3): total += dfs(N,N,i)
print(total)