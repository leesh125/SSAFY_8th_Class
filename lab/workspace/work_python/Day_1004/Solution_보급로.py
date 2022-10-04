INF = float('inf')
dr = [-1,1,0,0]
dc = [0,0,-1,1]

def dijkstra(startR, startC):
    # 출발지에서 자신으로의 최소 비용을 저장할 배열 생성 후 초기화
    minCost = [[INF] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]

    # 출발지에서 출발지로의 최소비용 0 처라
    minCost[startR][startC] = 0
    
    while True:
        r = -1; c = -1;
        # step1. 미방문정점중 최소비용 정점 찾기
        minTime = INF
        for i in range(N):
            for j in range(N):
                if not visited[i][j] and minTime > minCost[i][j]:
                    minTime = minCost[i][j]
                    r = i;  c = j
        
        # r,c -1일 경우는 더이상 갈 수 있는 정점이 없다
        if r == -1: break
        
        if r == N-1 and c == N-1: return minTime
        visited[r][c] = True
        
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0<=nr<N and 0<=nc<N and not visited[nr][nc] and minCost[nr][nc] > minTime + graph[nr][nc]:
                minCost[nr][nc] = minTime + graph[nr][nc]

for tc in range(1,int(input())+1):
    N = int(input())
    graph = [list(map(int,list(input().rstrip()))) for _ in range(N)]
    print('#{0} {1}'.format(tc, dijkstra(0,0)))

