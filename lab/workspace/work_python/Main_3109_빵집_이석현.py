import sys
input = sys.stdin.readline

def dfs(x,y):
    global pipeline, cnt

    if x < 0 or x >= N or y < 0 or y >= M or graph[x][y] == 'x' or cnt != 0:
        return

    graph[x][y] = 'x'
    if y == M-1:
        cnt += 1
        pipeline += 1
        return
    dfs(x-1,y+1)
    dfs(x,y+1)
    dfs(x+1,y+1)

N, M = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(N)]
pipeline = 0
cnt = 0
dir = [(-1,1), (0,1), (1,1)]

for i in range(N):
    dfs(i,0)
    cnt = 0
        
print(pipeline)