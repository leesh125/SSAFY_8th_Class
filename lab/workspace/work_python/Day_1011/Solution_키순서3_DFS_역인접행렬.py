def dfs(now,graph,visited): # 자신보다 키가 큰 학생따라 검색
    global cnt
    visited[now] = True

    for i in range(1, N+1):
        if graph[now][i] == 1 and not visited[i]: # i가 now보다 키가 큰경우(작은경우) 아직 탐색되지 않았다면
            cnt += 1 # 나보다 큰 학생 카운트
            dfs(i,graph,visited)

for tc in range(1, int(input())+1):
    N = int(input())
    M = int(input())
    ans = 0
    
    graph = [[0] * (N+1) for _ in range(N+1)] # 자신보다 큰 학생 정보
    r_graph = [[0] * (N+1) for _ in range(N+1)] # 자신보다 작은 학생 정보
    for i in range(M):
        a,b = map(int, input().split())
        graph[a][b] = 1 # a보다 b가 키가 크다
        r_graph[b][a] = 1 # b보다 a가 키가 작다
    
    for i in range(1,N+1):
        cnt = 0 # 나보다 큰(작은) 힉생 cnt
        dfs(i,graph,[False] * (N+1))
        dfs(i,r_graph,[False] * (N+1))
        if cnt == N-1: ans += 1

    print("#{0} {1}".format(tc, ans))

