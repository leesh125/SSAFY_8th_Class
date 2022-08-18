from collections import deque

def cost(k):
    return k * k + (k-1) * (k-1)

def bfs(i,j):
    global ans
    q = deque()
    q.append((i,j))
    visited = [[False] * N for _ in range(N)]
    visited[i][j] = True
    cnt,k = 0,1

    if graph[i][j] == 1: cnt += 1

    if cnt * M >= cost(k):
        ans = max(ans, cnt)

    while q:
        k+=1
        for _ in range(len(q)):
            x, y = q.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0<=nx<N and 0<=ny<N and not visited[nx][ny]:
                    if graph[nx][ny] == 1:
                        cnt += 1
                    visited[nx][ny] = True
                    q.append((nx,ny))
        
        if cnt * M >= cost(k):
            ans = max(ans, cnt)

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    graph = [list(map(int,input().split())) for _ in range(N)]
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    ans = int(-1e9)
    max_k = N+1 if N % 2 == 0 else N

    for i in range(N):
        for j in range(N):
            bfs(i,j)
    print('#{0} {1}'.format(tc,ans))